/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlFinanceInfo;
import com.terlu.modules.dao.TlFinanceInfoDao;

/**
 * 财务信息登记Service
 * @author wangqi
 * @version 2020-01-02
 */
@Service
@Transactional(readOnly = true)
public class TlFinanceInfoService extends CrudService<TlFinanceInfoDao, TlFinanceInfo> {

	public TlFinanceInfo get(String id) {
		return super.get(id);
	}
	
	public List<TlFinanceInfo> findList(TlFinanceInfo tlFinanceInfo) {
		return super.findList(tlFinanceInfo);
	}
	
	public Page<TlFinanceInfo> findPage(Page<TlFinanceInfo> page, TlFinanceInfo tlFinanceInfo) {
		return super.findPage(page, tlFinanceInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TlFinanceInfo tlFinanceInfo) {
		super.save(tlFinanceInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlFinanceInfo tlFinanceInfo) {
		super.delete(tlFinanceInfo);
	}
	
}