/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlDriverCard;
import com.terlu.modules.dao.TlDriverCardDao;

/**
 * 驾驶员身份证Service
 * @author wangqi
 * @version 2020-06-03
 */
@Service
@Transactional(readOnly = true)
public class TlDriverCardService extends CrudService<TlDriverCardDao, TlDriverCard> {

	public TlDriverCard get(String id) {
		return super.get(id);
	}
	
	public List<TlDriverCard> findList(TlDriverCard tlDriverCard) {
		return super.findList(tlDriverCard);
	}
	
	public Page<TlDriverCard> findPage(Page<TlDriverCard> page, TlDriverCard tlDriverCard) {
		return super.findPage(page, tlDriverCard);
	}
	
	@Transactional(readOnly = false)
	public void save(TlDriverCard tlDriverCard) {
		super.save(tlDriverCard);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlDriverCard tlDriverCard) {
		super.delete(tlDriverCard);
	}
	
	
}