/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlWeekScheduleDetails;
import com.terlu.modules.dao.TlWeekScheduleDetailsDao;

/**
 * 计划排班Service
 * @author sunlifeng
 * @version 2020-05-13
 */
@Service
@Transactional(readOnly = true)
public class TlWeekScheduleDetailsService extends CrudService<TlWeekScheduleDetailsDao, TlWeekScheduleDetails> {

	public TlWeekScheduleDetails get(String id) {
		return super.get(id);
	}
	
	public List<TlWeekScheduleDetails> findList(TlWeekScheduleDetails tlWeekScheduleDetails) {
		return super.findList(tlWeekScheduleDetails);
	}
	
	public Page<TlWeekScheduleDetails> findPage(Page<TlWeekScheduleDetails> page, TlWeekScheduleDetails tlWeekScheduleDetails) {
		return super.findPage(page, tlWeekScheduleDetails);
	}
	
	@Transactional(readOnly = false)
	public void save(TlWeekScheduleDetails tlWeekScheduleDetails) {
		super.save(tlWeekScheduleDetails);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlWeekScheduleDetails tlWeekScheduleDetails) {
		super.delete(tlWeekScheduleDetails);
	}
	
}