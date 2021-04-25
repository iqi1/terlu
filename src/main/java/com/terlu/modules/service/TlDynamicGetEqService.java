/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlDynamicGetEq;
import com.terlu.modules.dao.TlDynamicGetEqDao;

/**
 * 动态获取设备使用记录Service
 * @author wangqi
 * @version 2020-05-12
 */
@Service
@Transactional(readOnly = true)
public class TlDynamicGetEqService extends CrudService<TlDynamicGetEqDao, TlDynamicGetEq> {

	public TlDynamicGetEq get(String id) {
		return super.get(id);
	}
	
	public List<TlDynamicGetEq> findList(TlDynamicGetEq tlDynamicGetEq) {
		return super.findList(tlDynamicGetEq);
	}
	
	public Page<TlDynamicGetEq> findPage(Page<TlDynamicGetEq> page, TlDynamicGetEq tlDynamicGetEq) {
		return super.findPage(page, tlDynamicGetEq);
	}
	
	@Transactional(readOnly = false)
	public void save(TlDynamicGetEq tlDynamicGetEq) {
		super.save(tlDynamicGetEq);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlDynamicGetEq tlDynamicGetEq) {
		super.delete(tlDynamicGetEq);
	}
	
}