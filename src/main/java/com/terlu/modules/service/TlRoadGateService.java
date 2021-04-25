/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlRoadGate;
import com.terlu.modules.dao.TlRoadGateDao;

/**
 * 闸机信息Service
 * @author wangqi
 * @version 2020-01-10
 */
@Service
@Transactional(readOnly = true)
public class TlRoadGateService extends CrudService<TlRoadGateDao, TlRoadGate> {

	public TlRoadGate get(String id) {
		return super.get(id);
	}
	
	public List<TlRoadGate> findList(TlRoadGate tlRoadGate) {
		return super.findList(tlRoadGate);
	}
	
	public Page<TlRoadGate> findPage(Page<TlRoadGate> page, TlRoadGate tlRoadGate) {
		return super.findPage(page, tlRoadGate);
	}
	
	@Transactional(readOnly = false)
	public void save(TlRoadGate tlRoadGate) {
		super.save(tlRoadGate);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlRoadGate tlRoadGate) {
		super.delete(tlRoadGate);
	}
	
}