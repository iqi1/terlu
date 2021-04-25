/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlMainSchedule;
import com.terlu.modules.dao.TlMainScheduleDao;

/**
 * 周计划主表Service
 * @author wangqi
 * @version 2020-05-08
 */
@Service
@Transactional(readOnly = true)
public class TlMainScheduleService extends CrudService<TlMainScheduleDao, TlMainSchedule> {

	public TlMainSchedule get(String id) {
		return super.get(id);
	}
	
	public List<TlMainSchedule> findList(TlMainSchedule tlMainSchedule) {
		return super.findList(tlMainSchedule);
	}
	
	public Page<TlMainSchedule> findPage(Page<TlMainSchedule> page, TlMainSchedule tlMainSchedule) {
		return super.findPage(page, tlMainSchedule);
	}
	
	@Transactional(readOnly = false)
	public void save(TlMainSchedule tlMainSchedule) {
		super.save(tlMainSchedule);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlMainSchedule tlMainSchedule) {
		super.delete(tlMainSchedule);
	}
	
}