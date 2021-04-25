/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlFuelManage;
import com.terlu.modules.dao.TlFuelManageDao;

/**
 * 加油申请Service
 * @author wangqi
 * @version 2020-02-05
 */
@Service
@Transactional(readOnly = true)
public class TlFuelManageService extends CrudService<TlFuelManageDao, TlFuelManage> {

	public TlFuelManage get(String id) {
		return super.get(id);
	}
	
	public List<TlFuelManage> findList(TlFuelManage tlFuelManage) {
		return super.findList(tlFuelManage);
	}
	
	public Page<TlFuelManage> findPage(Page<TlFuelManage> page, TlFuelManage tlFuelManage) {
		return super.findPage(page, tlFuelManage);
	}
	
	@Transactional(readOnly = false)
	public void save(TlFuelManage tlFuelManage) {
		super.save(tlFuelManage);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlFuelManage tlFuelManage) {
		super.delete(tlFuelManage);
	}
	
}