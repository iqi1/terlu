/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlTestCarPlan;
import com.terlu.modules.dao.TlTestCarPlanDao;

/**
 * 测试车俩 计划Service
 * @author sunlifeng
 * @version 2020-05-14
 */
@Service
@Transactional(readOnly = true)
public class TlTestCarPlanService extends CrudService<TlTestCarPlanDao, TlTestCarPlan> {

	public TlTestCarPlan get(String id) {
		return super.get(id);
	}
	
	public List<TlTestCarPlan> findList(TlTestCarPlan tlTestCarPlan) {
		return super.findList(tlTestCarPlan);
	}
	
	public Page<TlTestCarPlan> findPage(Page<TlTestCarPlan> page, TlTestCarPlan tlTestCarPlan) {
		return super.findPage(page, tlTestCarPlan);
	}
	
	@Transactional(readOnly = false)
	public void save(TlTestCarPlan tlTestCarPlan) {
		super.save(tlTestCarPlan);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlTestCarPlan tlTestCarPlan) {
		super.delete(tlTestCarPlan);
	}
	
}