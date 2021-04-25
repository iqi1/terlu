/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlProjectPlan;
import com.terlu.modules.dao.TlProjectPlanDao;

/**
 * 项目计划Service
 * @author wangqi
 * @version 2020-02-19
 */
@Service
@Transactional(readOnly = true)
public class TlProjectPlanService extends CrudService<TlProjectPlanDao, TlProjectPlan> {

	public TlProjectPlan get(String id) {
		return super.get(id);
	}
	
	public List<TlProjectPlan> findList(TlProjectPlan tlProjectPlan) {
		return super.findList(tlProjectPlan);
	}
	
	public Page<TlProjectPlan> findPage(Page<TlProjectPlan> page, TlProjectPlan tlProjectPlan) {
		return super.findPage(page, tlProjectPlan);
	}
	
	@Transactional(readOnly = false)
	public void save(TlProjectPlan tlProjectPlan) {
		super.save(tlProjectPlan);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlProjectPlan tlProjectPlan) {
		super.delete(tlProjectPlan);
	}
	
}