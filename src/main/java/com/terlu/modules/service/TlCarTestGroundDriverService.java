/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlCarTestGroundDriver;
import com.terlu.modules.dao.TlCarTestGroundDriverDao;

/**
 * 驾驶员管理Service
 * @author wangqi
 * @version 2020-01-08
 */
@Service
@Transactional(readOnly = true)
public class TlCarTestGroundDriverService extends CrudService<TlCarTestGroundDriverDao, TlCarTestGroundDriver> {

	public TlCarTestGroundDriver get(String id) {
		return super.get(id);
	}
	
	public List<TlCarTestGroundDriver> findList(TlCarTestGroundDriver tlCarTestGroundDriver) {
		return super.findList(tlCarTestGroundDriver);
	}
	
	public Page<TlCarTestGroundDriver> findPage(Page<TlCarTestGroundDriver> page, TlCarTestGroundDriver tlCarTestGroundDriver) {
		return super.findPage(page, tlCarTestGroundDriver);
	}
	
	@Transactional(readOnly = false)
	public void save(TlCarTestGroundDriver tlCarTestGroundDriver) {
		super.save(tlCarTestGroundDriver);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlCarTestGroundDriver tlCarTestGroundDriver) {
		super.delete(tlCarTestGroundDriver);
	}
	
}