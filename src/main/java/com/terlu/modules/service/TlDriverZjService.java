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
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.terlu.modules.entity.TlCustomBaseinfo;
import com.terlu.modules.entity.TlDriverZj;
import com.terlu.modules.dao.TlDriverZjDao;

/**
 * 驾驶员证件Service
 * @author wangqi
 * @version 2020-06-02
 */
@Service
@Transactional(readOnly = true)
public class TlDriverZjService extends CrudService<TlDriverZjDao, TlDriverZj> {
	@Autowired
	private ActTaskService actTaskService;
	
	@Autowired
	protected TaskService taskService;

	public TlDriverZj get(String id) {
		return super.get(id);
	}
	
	public List<TlDriverZj> findList(TlDriverZj tlDriverZj) {
		return super.findList(tlDriverZj);
	}
	
	public Page<TlDriverZj> findPage(Page<TlDriverZj> page, TlDriverZj tlDriverZj) {
		return super.findPage(page, tlDriverZj);
	}
	
	@Transactional(readOnly = false)
	public void save(TlDriverZj tlDriverZj) {
		super.save(tlDriverZj);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlDriverZj tlDriverZj) {
		super.delete(tlDriverZj);
	}
	
	//流程开始
	@Transactional(readOnly = false)
	public void submitAudit(TlDriverZj tlDriverZj) {
		String id = tlDriverZj.getId();
		actTaskService.startProcess("DriverZJBL", "tl_driver_zj", id);
	}
	
	@Transactional(readOnly = false)
	public void audit(TlDriverZj tlDriverZj) {
		int pass = tlDriverZj.getStatus();
		// 设置意见
		String comment = ((pass == 1)?"[同意] ":"[驳回] ") + tlDriverZj.getComment();
		tlDriverZj = get(tlDriverZj.getId());
		Task task =  taskService.createTaskQuery().processInstanceId(tlDriverZj.getProcInsId()).singleResult();
		String strt = task.getTaskDefinitionKey();
		Map<String, Object> variables = new HashMap<String, Object>();
		if(strt.equals("audit1")){
			if (pass == 1) {
//				variables.put("userID", tlDriverZj.getUserLeader().getName());
				variables.put("pass", pass);
				this.save(tlDriverZj);
			} else {
//				variables.put("userID", tlDriverZj.getUserAuthorizer().getName());
				variables.put("apply", tlDriverZj.getName());
				variables.put("pass", pass);
			}
			actTaskService.complete(task.getId(), tlDriverZj.getProcInsId(), comment, variables);	
		}else if(strt.equals("modify1")){
			if(pass==1) {
				variables.put("pass", pass);
				actTaskService.complete(task.getId(), tlDriverZj.getProcInsId(), comment, variables);
			}else {
				variables.put("apply", tlDriverZj.getName());
				variables.put("pass", pass);
			}
			actTaskService.complete(task.getId(), tlDriverZj.getProcInsId(), comment, variables);
		}
	}
	
	public Page<TlDriverZj> findToDoTaskPage(TlDriverZj tlDriverZj) {
		Act act = new Act();
		act.setProcDefKey("DriverZJBL");
		List<Act> list = actTaskService.todoList(act);
		String businessId = "";
		List<TlDriverZj> results = new ArrayList<TlDriverZj>();
		for(Act ac : list) {
			String businessKey = ac.getBusinessId();
			int beginIndex = businessKey.indexOf(":") + 1;
			if(beginIndex > 0) {
				businessId = businessKey.substring(beginIndex,beginIndex + 32);
			}
			TlDriverZj data = dao.get(businessId);
			if(data != null && data.getDelFlag().equals("0")) {
				data.setStatus(3);
				results.add(data);
			}
		}
		Page<TlDriverZj> page = new Page<TlDriverZj>();
		page.setList(results);
		return page;
	}
	
}