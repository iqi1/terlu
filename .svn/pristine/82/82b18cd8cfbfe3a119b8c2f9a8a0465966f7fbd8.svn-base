/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlCardRecord;
import com.terlu.modules.dao.TlCardRecordDao;

/**
 * 卡记录Service
 * @author wangqi
 * @version 2020-01-14
 */
@Service
@Transactional(readOnly = true)
public class TlCardRecordService extends CrudService<TlCardRecordDao, TlCardRecord> {

	public TlCardRecord get(String id) {
		return super.get(id);
	}
	
	public List<TlCardRecord> findList(TlCardRecord tlCardRecord) {
		return super.findList(tlCardRecord);
	}
	
	public Page<TlCardRecord> findPage(Page<TlCardRecord> page, TlCardRecord tlCardRecord) {
		return super.findPage(page, tlCardRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(TlCardRecord tlCardRecord) {
		super.save(tlCardRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlCardRecord tlCardRecord) {
		super.delete(tlCardRecord);
	}
	
}