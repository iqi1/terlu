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

import com.terlu.modules.dao.TlCustomBaseinfoDao;
import com.terlu.modules.entity.TlCustomBaseinfo;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.act.entity.Act;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 试验测试申请表Service
 * @author sunlifeng
 * @version 2019-12-27
 */
@Service
@Transactional(readOnly = true)
public class TlCustomBaseinfoService extends CrudService<TlCustomBaseinfoDao, TlCustomBaseinfo> {

	@Autowired
	private ActTaskService actTaskService;
	
	@Autowired
	protected TaskService taskService;
	
	public TlCustomBaseinfo get(String id) {
		return super.get(id);
	}
	
	public List<TlCustomBaseinfo> findList(TlCustomBaseinfo tlCustomBaseinfo) {
		return super.findList(tlCustomBaseinfo);
	}
	
	public Page<TlCustomBaseinfo> findPage(Page<TlCustomBaseinfo> page, TlCustomBaseinfo tlCustomBaseinfo) {
		return super.findPage(page, tlCustomBaseinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TlCustomBaseinfo tlCustomBaseinfo) {
		super.save(tlCustomBaseinfo);
	}
	
	@Transactional(readOnly = false)
	public void submitAudit(TlCustomBaseinfo tlCustomBaseinfo) {
		
		String id = tlCustomBaseinfo.getId();
		actTaskService.startProcess("TestAppointment", "tl_custom_baseinfo", id);
		
	}
	
	@Transactional(readOnly = false)
	public void audit(TlCustomBaseinfo tlCustomBaseinfo) {
		int pass = tlCustomBaseinfo.getStatus();
		// 设置意见
		String comment = ((pass == 1)?"[同意] ":"[驳回] ") + tlCustomBaseinfo.getComment();
		tlCustomBaseinfo = get(tlCustomBaseinfo.getId());
		Task task =  taskService.createTaskQuery().processInstanceId(tlCustomBaseinfo.getProcInsId()).singleResult();
		String strt = task.getTaskDefinitionKey();
		Map<String, Object> variables = new HashMap<String, Object>();
		

		
		if(strt.equals("audit1")){
			if (pass == 1) {
				variables.put("userID", tlCustomBaseinfo.getUserLeader().getName());
				variables.put("pass", pass);
				User user = UserUtils.getUser();
				tlCustomBaseinfo.setMarketId(user.getId());
				this.save(tlCustomBaseinfo);
			} else {
				variables.put("userID", tlCustomBaseinfo.getUserAuthorizer().getName());
				variables.put("pass", pass);
			}
			
			actTaskService.complete(task.getId(), tlCustomBaseinfo.getProcInsId(), comment, variables);	
		}else if(strt.equals("modify1")){
			variables.put("pass", pass);
			actTaskService.complete(task.getId(), tlCustomBaseinfo.getProcInsId(), comment, variables);
		}else if(strt.equals("audit2")){
			variables.put("pass", pass);
			actTaskService.complete(task.getId(), tlCustomBaseinfo.getProcInsId(), comment, variables);
		}else if(strt.equals("audit3")){
			if (pass == 1) {
				variables.put("pass", pass);
				User user = UserUtils.getUser();
				tlCustomBaseinfo.setFieldId(user.getId());
				this.save(tlCustomBaseinfo);
			} else {
				variables.put("userID", tlCustomBaseinfo.getUserLeader().getName());
				variables.put("pass", pass);
			}
			
			actTaskService.complete(task.getId(), tlCustomBaseinfo.getProcInsId(), comment, variables);
		}
	}
	
	public Page<TlCustomBaseinfo> findToDoTaskPage(TlCustomBaseinfo tlCustomBaseinfo) {
		
		Act act = new Act();
		act.setProcDefKey("TestAppointment");
		List<Act> list = actTaskService.todoList(act);
		// 根据流程的业务ID查询实体并关联
		String businessId = "";
		
		List<TlCustomBaseinfo> results = new ArrayList<TlCustomBaseinfo>();
		for(Act ac : list) {
			String businessKey = ac.getBusinessId();
			if(StringUtils.isNotBlank(businessKey)){
//				businessId = businessKey.split("\\:")[1];
//				businessId = businessId.split(",")[0];
				int beginIndex = businessKey.indexOf(":") + 1;
				if(beginIndex > 0)
					businessId = businessKey.substring(beginIndex, beginIndex +32);
	        }
			
			
			
			TlCustomBaseinfo data = dao.get(businessId);
			
			if(data != null && data.getDelFlag().equals("0")){
				data.setStatus(3);
				results.add(data);
			}
			
		}
		Page<TlCustomBaseinfo> page = new Page<TlCustomBaseinfo>();
		page.setList(results);
		return page;
	}
	
	@Transactional(readOnly = false)
	public void delete(TlCustomBaseinfo tlCustomBaseinfo) {
		super.delete(tlCustomBaseinfo);
	}
	
}