/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlDriverQualification;
import com.terlu.modules.dao.TlDriverQualificationDao;

/**
 * 驾驶员资质Service
 * @author wangqi
 * @version 2020-02-19
 */
@Service
@Transactional(readOnly = true)
public class TlDriverQualificationService extends CrudService<TlDriverQualificationDao, TlDriverQualification> {

	public TlDriverQualification get(String id) {
		return super.get(id);
	}
	
	public List<TlDriverQualification> findList(TlDriverQualification tlDriverQualification) {
		return super.findList(tlDriverQualification);
	}
	
	public Page<TlDriverQualification> findPage(Page<TlDriverQualification> page, TlDriverQualification tlDriverQualification) {
		return super.findPage(page, tlDriverQualification);
	}
	
	@Transactional(readOnly = false)
	public void save(TlDriverQualification tlDriverQualification) {
		super.save(tlDriverQualification);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlDriverQualification tlDriverQualification) {
		super.delete(tlDriverQualification);
	}
	
}