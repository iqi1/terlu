/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlSettleAccounts;
import com.terlu.modules.dao.TlSettleAccountsDao;

/**
 * 结算统计Service
 * @author wangqi
 * @version 2020-02-20
 */
@Service
@Transactional(readOnly = true)
public class TlSettleAccountsService extends CrudService<TlSettleAccountsDao, TlSettleAccounts> {

	public TlSettleAccounts get(String id) {
		return super.get(id);
	}
	
	public List<TlSettleAccounts> findList(TlSettleAccounts tlSettleAccounts) {
		return super.findList(tlSettleAccounts);
	}
	
	public Page<TlSettleAccounts> findPage(Page<TlSettleAccounts> page, TlSettleAccounts tlSettleAccounts) {
		return super.findPage(page, tlSettleAccounts);
	}
	
	@Transactional(readOnly = false)
	public void save(TlSettleAccounts tlSettleAccounts) {
		super.save(tlSettleAccounts);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlSettleAccounts tlSettleAccounts) {
		super.delete(tlSettleAccounts);
	}
	
}