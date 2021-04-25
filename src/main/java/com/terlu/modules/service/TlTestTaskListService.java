/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlTestTaskList;
import com.terlu.modules.dao.TlTestTaskListDao;

/**
 * 试验任务单Service
 * @author sunlifeng
 * @version 2020-01-06
 */
@Service
@Transactional(readOnly = true)
public class TlTestTaskListService extends CrudService<TlTestTaskListDao, TlTestTaskList> {

	public TlTestTaskList get(String id) {
		return super.get(id);
	}
	
	public List<TlTestTaskList> findList(TlTestTaskList tlTestTaskList) {
		return super.findList(tlTestTaskList);
	}
	
	public Page<TlTestTaskList> findPage(Page<TlTestTaskList> page, TlTestTaskList tlTestTaskList) {
		return super.findPage(page, tlTestTaskList);
	}
	
	@Transactional(readOnly = false)
	public void save(TlTestTaskList tlTestTaskList) {
		super.save(tlTestTaskList);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlTestTaskList tlTestTaskList) {
		super.delete(tlTestTaskList);
	}
	
}