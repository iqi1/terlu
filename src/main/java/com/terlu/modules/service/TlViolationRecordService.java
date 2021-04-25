/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlViolationRecord;
import com.terlu.modules.dao.TlViolationRecordDao;

/**
 * 违规记录Service
 * @author wangqi
 * @version 2020-01-08
 */
@Service
@Transactional(readOnly = true)
public class TlViolationRecordService extends CrudService<TlViolationRecordDao, TlViolationRecord> {

	public TlViolationRecord get(String id) {
		return super.get(id);
	}
	
	public List<TlViolationRecord> findList(TlViolationRecord tlViolationRecord) {
		return super.findList(tlViolationRecord);
	}
	
	public Page<TlViolationRecord> findPage(Page<TlViolationRecord> page, TlViolationRecord tlViolationRecord) {
		return super.findPage(page, tlViolationRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(TlViolationRecord tlViolationRecord) {
		super.save(tlViolationRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlViolationRecord tlViolationRecord) {
		super.delete(tlViolationRecord);
	}
	
}