/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlStaticWriteEq;
import com.terlu.modules.dao.TlStaticWriteEqDao;

/**
 * 静态录入设备信息表Service
 * @author wangqi
 * @version 2020-05-12
 */
@Service
@Transactional(readOnly = true)
public class TlStaticWriteEqService extends CrudService<TlStaticWriteEqDao, TlStaticWriteEq> {

	public TlStaticWriteEq get(String id) {
		return super.get(id);
	}
	
	public List<TlStaticWriteEq> findList(TlStaticWriteEq tlStaticWriteEq) {
		return super.findList(tlStaticWriteEq);
	}
	
	public Page<TlStaticWriteEq> findPage(Page<TlStaticWriteEq> page, TlStaticWriteEq tlStaticWriteEq) {
		return super.findPage(page, tlStaticWriteEq);
	}
	
	@Transactional(readOnly = false)
	public void save(TlStaticWriteEq tlStaticWriteEq) {
		super.save(tlStaticWriteEq);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlStaticWriteEq tlStaticWriteEq) {
		super.delete(tlStaticWriteEq);
	}
	
}