/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlCarInfo;
import com.terlu.modules.dao.TlCarInfoDao;

/**
 * 车辆信息登记Service
 * @author wangqi
 * @version 2019-12-30
 */
@Service
@Transactional(readOnly = true)
public class TlCarInfoService extends CrudService<TlCarInfoDao, TlCarInfo> {

	public TlCarInfo get(String id) {
		return super.get(id);
	}
	
	public List<TlCarInfo> findList(TlCarInfo tlCarInfo) {
		return super.findList(tlCarInfo);
	}
	
	public Page<TlCarInfo> findPage(Page<TlCarInfo> page, TlCarInfo tlCarInfo) {
		return super.findPage(page, tlCarInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TlCarInfo tlCarInfo) {
		super.save(tlCarInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlCarInfo tlCarInfo) {
		super.delete(tlCarInfo);
	}
	
}