/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlVistorRegister;
import com.terlu.modules.dao.TlVistorRegisterDao;

/**
 * 到访人员信息登记Service
 * @author sunlifeng
 * @version 2019-12-30
 */
@Service
@Transactional(readOnly = true)
public class TlVistorRegisterService extends CrudService<TlVistorRegisterDao, TlVistorRegister> {

	public TlVistorRegister get(String id) {
		return super.get(id);
	}
	
	public List<TlVistorRegister> findList(TlVistorRegister tlVistorRegister) {
		return super.findList(tlVistorRegister);
	}
	
	public Page<TlVistorRegister> findPage(Page<TlVistorRegister> page, TlVistorRegister tlVistorRegister) {
		return super.findPage(page, tlVistorRegister);
	}
	
	@Transactional(readOnly = false)
	public void save(TlVistorRegister tlVistorRegister) {
		super.save(tlVistorRegister);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlVistorRegister tlVistorRegister) {
		super.delete(tlVistorRegister);
	}
	
}