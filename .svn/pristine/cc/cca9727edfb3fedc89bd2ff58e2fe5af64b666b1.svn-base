/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlSeal;
import com.terlu.modules.dao.TlSealDao;

/**
 * 电子签名Service
 * @author sunlifeng
 * @version 2020-01-06
 */
@Service
@Transactional(readOnly = true)
public class TlSealService extends CrudService<TlSealDao, TlSeal> {

	public TlSeal get(String id) {
		return super.get(id);
	}
	
	public List<TlSeal> findList(TlSeal tlSeal) {
		return super.findList(tlSeal);
	}
	
	public Page<TlSeal> findPage(Page<TlSeal> page, TlSeal tlSeal) {
		return super.findPage(page, tlSeal);
	}
	
	@Transactional(readOnly = false)
	public void save(TlSeal tlSeal) {
		super.save(tlSeal);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlSeal tlSeal) {
		super.delete(tlSeal);
	}
	
}