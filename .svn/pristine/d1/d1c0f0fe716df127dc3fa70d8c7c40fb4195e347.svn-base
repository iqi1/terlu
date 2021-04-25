/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlTestprojectChild;
import com.terlu.modules.dao.TlTestprojectChildDao;

/**
 * 测试项目Service
 * @author sunlifeng
 * @version 2019-12-27
 */
@Service
@Transactional(readOnly = true)
public class TlTestprojectChildService extends CrudService<TlTestprojectChildDao, TlTestprojectChild> {

	public TlTestprojectChild get(String id) {
		return super.get(id);
	}
	
	public List<TlTestprojectChild> findList(TlTestprojectChild tlTestprojectChild) {
		return super.findList(tlTestprojectChild);
	}
	
	public Page<TlTestprojectChild> findPage(Page<TlTestprojectChild> page, TlTestprojectChild tlTestprojectChild) {
		return super.findPage(page, tlTestprojectChild);
	}
	
	@Transactional(readOnly = false)
	public void save(TlTestprojectChild tlTestprojectChild) {
		super.save(tlTestprojectChild);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlTestprojectChild tlTestprojectChild) {
		super.delete(tlTestprojectChild);
	}
	
}