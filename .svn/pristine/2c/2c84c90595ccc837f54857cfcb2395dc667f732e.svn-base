/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlDriverAblility;
import com.terlu.modules.dao.TlDriverAblilityDao;

/**
 * 驾驶员能力评估Service
 * @author wangqi
 * @version 2020-06-02
 */
@Service
@Transactional(readOnly = true)
public class TlDriverAblilityService extends CrudService<TlDriverAblilityDao, TlDriverAblility> {

	public TlDriverAblility get(String id) {
		return super.get(id);
	}
	
	public List<TlDriverAblility> findList(TlDriverAblility tlDriverAblility) {
		return super.findList(tlDriverAblility);
	}
	
	public Page<TlDriverAblility> findPage(Page<TlDriverAblility> page, TlDriverAblility tlDriverAblility) {
		return super.findPage(page, tlDriverAblility);
	}
	
	@Transactional(readOnly = false)
	public void save(TlDriverAblility tlDriverAblility) {
		super.save(tlDriverAblility);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlDriverAblility tlDriverAblility) {
		super.delete(tlDriverAblility);
	}
	
}