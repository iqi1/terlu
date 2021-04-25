/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlWeekSchedule;
import com.terlu.modules.dao.TlWeekScheduleDao;

/**
 * 周计划附表Service
 * @author wangqi
 * @version 2020-05-08
 */
@Service
@Transactional(readOnly = true)
public class TlWeekScheduleService extends CrudService<TlWeekScheduleDao, TlWeekSchedule> {

	public TlWeekSchedule get(String id) {
		return super.get(id);
	}
	
	public List<TlWeekSchedule> findList(TlWeekSchedule tlWeekSchedule) {
		return super.findList(tlWeekSchedule);
	}
	
	public Page<TlWeekSchedule> findPage(Page<TlWeekSchedule> page, TlWeekSchedule tlWeekSchedule) {
		return super.findPage(page, tlWeekSchedule);
	}
	
	@Transactional(readOnly = false)
	public void save(TlWeekSchedule tlWeekSchedule) {
		super.save(tlWeekSchedule);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlWeekSchedule tlWeekSchedule) {
		super.delete(tlWeekSchedule);
	}
	
}