/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlInOutRecord;
import com.terlu.modules.dao.TlInOutRecordDao;

/**
 * 进出记录Service
 * @author wangqi
 * @version 2020-01-14
 */
@Service
@Transactional(readOnly = true)
public class TlInOutRecordService extends CrudService<TlInOutRecordDao, TlInOutRecord> {

	public TlInOutRecord get(String id) {
		return super.get(id);
	}
	
	public List<TlInOutRecord> findList(TlInOutRecord tlInOutRecord) {
		return super.findList(tlInOutRecord);
	}
	
	public Page<TlInOutRecord> findPage(Page<TlInOutRecord> page, TlInOutRecord tlInOutRecord) {
		return super.findPage(page, tlInOutRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(TlInOutRecord tlInOutRecord) {
		super.save(tlInOutRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlInOutRecord tlInOutRecord) {
		super.delete(tlInOutRecord);
	}
	
}