/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlEquDis;
import com.terlu.modules.dao.TlEquDisDao;

/**
 * 设备分配表Service
 * @author wangqi
 * @version 2020-05-06
 */
@Service
@Transactional(readOnly = true)
public class TlEquDisService extends CrudService<TlEquDisDao, TlEquDis> {

	public TlEquDis get(String id) {
		return super.get(id);
	}
	
	public List<TlEquDis> findList(TlEquDis tlEquDis) {
		return super.findList(tlEquDis);
	}
	
	public Page<TlEquDis> findPage(Page<TlEquDis> page, TlEquDis tlEquDis) {
		return super.findPage(page, tlEquDis);
	}
	
	@Transactional(readOnly = false)
	public void save(TlEquDis tlEquDis) {
		super.save(tlEquDis);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlEquDis tlEquDis) {
		super.delete(tlEquDis);
	}
	
}