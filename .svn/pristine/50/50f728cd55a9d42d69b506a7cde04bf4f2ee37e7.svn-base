/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TsAppointment;
import com.terlu.modules.dao.TsAppointmentDao;

/**
 * 试验预约Service
 * @author sunlifeng
 * @version 2019-12-25
 */
@Service
@Transactional(readOnly = true)
public class TsAppointmentService extends CrudService<TsAppointmentDao, TsAppointment> {

	public TsAppointment get(String id) {
		return super.get(id);
	}
	
	public List<TsAppointment> findList(TsAppointment tsAppointment) {
		return super.findList(tsAppointment);
	}
	
	public Page<TsAppointment> findPage(Page<TsAppointment> page, TsAppointment tsAppointment) {
		return super.findPage(page, tsAppointment);
	}
	
	@Transactional(readOnly = false)
	public void save(TsAppointment tsAppointment) {
		super.save(tsAppointment);
	}
	
	@Transactional(readOnly = false)
	public void delete(TsAppointment tsAppointment) {
		super.delete(tsAppointment);
	}
	
}