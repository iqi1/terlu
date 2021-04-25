/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlFuelchargeCard;
import com.terlu.modules.dao.TlFuelchargeCardDao;

/**
 * 油/电卡Service
 * @author wangqi
 * @version 2020-02-10
 */
@Service
@Transactional(readOnly = true)
public class TlFuelchargeCardService extends CrudService<TlFuelchargeCardDao, TlFuelchargeCard> {

	public TlFuelchargeCard get(String id) {
		return super.get(id);
	}
	
	public List<TlFuelchargeCard> findList(TlFuelchargeCard tlFuelchargeCard) {
		return super.findList(tlFuelchargeCard);
	}
	
	public Page<TlFuelchargeCard> findPage(Page<TlFuelchargeCard> page, TlFuelchargeCard tlFuelchargeCard) {
		return super.findPage(page, tlFuelchargeCard);
	}
	
	@Transactional(readOnly = false)
	public void save(TlFuelchargeCard tlFuelchargeCard) {
		super.save(tlFuelchargeCard);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlFuelchargeCard tlFuelchargeCard) {
		super.delete(tlFuelchargeCard);
	}
	
}