/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlMidRoadGate;
import com.terlu.modules.dao.TlMidRoadGateDao;

/**
 * 场地控制Service
 * @author wangqi
 * @version 2020-01-10
 */
@Service
@Transactional(readOnly = true)
public class TlMidRoadGateService extends CrudService<TlMidRoadGateDao, TlMidRoadGate> {

	public TlMidRoadGate get(String id) {
		return super.get(id);
	}
	
	public List<TlMidRoadGate> findList(TlMidRoadGate tlMidRoadGate) {
		return super.findList(tlMidRoadGate);
	}
	
	public Page<TlMidRoadGate> findPage(Page<TlMidRoadGate> page, TlMidRoadGate tlMidRoadGate) {
		return super.findPage(page, tlMidRoadGate);
	}
	
	@Transactional(readOnly = false)
	public void save(TlMidRoadGate tlMidRoadGate) {
		super.save(tlMidRoadGate);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlMidRoadGate tlMidRoadGate) {
		super.delete(tlMidRoadGate);
	}
	
}