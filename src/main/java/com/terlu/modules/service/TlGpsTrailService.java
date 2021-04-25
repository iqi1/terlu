/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlGpsTrail;
import com.terlu.modules.dao.TlGpsTrailDao;

/**
 * 定位轨迹Service
 * @author wangqi
 * @version 2020-05-06
 */
@Service
@Transactional(readOnly = true)
public class TlGpsTrailService extends CrudService<TlGpsTrailDao, TlGpsTrail> {

	public TlGpsTrail get(String id) {
		return super.get(id);
	}
	
	public List<TlGpsTrail> findList(TlGpsTrail tlGpsTrail) {
		return super.findList(tlGpsTrail);
	}
	
	public Page<TlGpsTrail> findPage(Page<TlGpsTrail> page, TlGpsTrail tlGpsTrail) {
		return super.findPage(page, tlGpsTrail);
	}
	
	@Transactional(readOnly = false)
	public void save(TlGpsTrail tlGpsTrail) {
		super.save(tlGpsTrail);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlGpsTrail tlGpsTrail) {
		super.delete(tlGpsTrail);
	}
	
}