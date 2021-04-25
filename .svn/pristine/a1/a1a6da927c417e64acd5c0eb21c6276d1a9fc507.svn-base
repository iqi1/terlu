/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlCardState;
import com.terlu.modules.dao.TlCardStateDao;

/**
 * 卡状态Service
 * @author wangqi
 * @version 2020-01-14
 */
@Service
@Transactional(readOnly = true)
public class TlCardStateService extends CrudService<TlCardStateDao, TlCardState> {

	public TlCardState get(String id) {
		return super.get(id);
	}
	
	public List<TlCardState> findList(TlCardState tlCardState) {
		return super.findList(tlCardState);
	}
	
	public Page<TlCardState> findPage(Page<TlCardState> page, TlCardState tlCardState) {
		return super.findPage(page, tlCardState);
	}
	
	@Transactional(readOnly = false)
	public void save(TlCardState tlCardState) {
		super.save(tlCardState);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlCardState tlCardState) {
		super.delete(tlCardState);
	}
	
}