/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.act.entity.Act;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.terlu.modules.entity.TlContract;
import com.terlu.modules.entity.TlDriverZj;
import com.terlu.modules.dao.TlContractDao;

/**
 * 合同添加Service
 * @author wangqi
 * @version 2020-02-17
 */
@Service
@Transactional(readOnly = true)
public class TlContractService extends CrudService<TlContractDao, TlContract> {
	
	@Autowired
	private ActTaskService actTaskService;
	
	@Autowired
	protected TaskService taskService;

	public TlContract get(String id) {
		return super.get(id);
	}
	
	public List<TlContract> findList(TlContract tlContract) {
		return super.findList(tlContract);
	}
	
	public Page<TlContract> findPage(Page<TlContract> page, TlContract tlContract) {
		return super.findPage(page, tlContract);
	}
	
	@Transactional(readOnly = false)
	public void save(TlContract tlContract) {
		super.save(tlContract);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlContract tlContract) {
		super.delete(tlContract);
	}
	
	//流程开始
		@Transactional(readOnly = false)
		public void submitAudit(TlContract tlContract) {
			
			String id = tlContract.getId();
			actTaskService.startProcess("tlContract", "tl_contract", id);
		}
		
		@Transactional(readOnly = false)
		public void audit(TlContract tlContract) {
			int pass = tlContract.getStatus();
			// 设置意见
			String comment = ((pass == 1)?"[同意] ":"[驳回] ") + tlContract.getComment();
			tlContract = get(tlContract.getId());
			Task task =  taskService.createTaskQuery().processInstanceId(tlContract.getProcInsId()).singleResult();
			String strt = task.getTaskDefinitionKey();
			Map<String, Object> variables = new HashMap<String, Object>();
			if(strt.equals("audit1")){
				if (pass == 1) {
//					variables.put("userID", tlDriverZj.getUserLeader().getName());
					variables.put("pass", pass);
					this.save(tlContract);
				} else {
//					variables.put("userID", tlDriverZj.getUserAuthorizer().getName());
					variables.put("apply", tlContract.getCreateBy().getName());
					variables.put("pass", pass);
				}
				actTaskService.complete(task.getId(), tlContract.getProcInsId(), comment, variables);	
			}else if(strt.equals("modify1")){
				if(pass==1) {
					variables.put("pass", pass);
					actTaskService.complete(task.getId(), tlContract.getProcInsId(), comment, variables);
				}else {
					variables.put("apply", tlContract.getCreateBy().getName());
					variables.put("pass", pass);
				}
				actTaskService.complete(task.getId(), tlContract.getProcInsId(), comment, variables);
			}
		}
		
		public Page<TlContract> findToDoTaskPage(TlContract tlContract) {
			Act act = new Act();
			act.setProcDefKey("tlContract");
			List<Act> list = actTaskService.todoList(act);
			String businessId = "";
			List<TlContract> results = new ArrayList<TlContract>();
			for(Act ac : list) {
				String businessKey = ac.getBusinessId();
				int beginIndex = businessKey.indexOf(":") + 1;
				if(beginIndex > 0) {
					businessId = businessKey.substring(beginIndex,beginIndex + 32);
				}
				TlContract data = dao.get(businessId);
				if(data != null && data.getDelFlag().equals("0")) {
					data.setStatus(3);
					results.add(data);
				}
			}
			Page<TlContract> page = new Page<TlContract>();
			page.setList(results);
			return page;
		}
	
	
}