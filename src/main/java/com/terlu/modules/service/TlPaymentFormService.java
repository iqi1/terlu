/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlPaymentForm;
import com.terlu.modules.dao.TlPaymentFormDao;

/**
 * 结算单主表Service
 * @author wangqi
 * @version 2020-02-25
 */
@Service
@Transactional(readOnly = true)
public class TlPaymentFormService extends CrudService<TlPaymentFormDao, TlPaymentForm> {

	public TlPaymentForm get(String id) {
		return super.get(id);
	}
	
	public List<TlPaymentForm> findList(TlPaymentForm tlPaymentForm) {
		return super.findList(tlPaymentForm);
	}
	
	public Page<TlPaymentForm> findPage(Page<TlPaymentForm> page, TlPaymentForm tlPaymentForm) {
		return super.findPage(page, tlPaymentForm);
	}
	
	@Transactional(readOnly = false)
	public void save(TlPaymentForm tlPaymentForm) {
		super.save(tlPaymentForm);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlPaymentForm tlPaymentForm) {
		super.delete(tlPaymentForm);
	}
	
}