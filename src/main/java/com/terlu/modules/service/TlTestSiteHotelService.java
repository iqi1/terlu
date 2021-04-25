/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlTestSiteHotel;
import com.terlu.modules.dao.TlTestSiteHotelDao;

/**
 * 试验场酒店预定Service
 * @author wangqi
 * @version 2019-12-30
 */
@Service
@Transactional(readOnly = true)
public class TlTestSiteHotelService extends CrudService<TlTestSiteHotelDao, TlTestSiteHotel> {

	public TlTestSiteHotel get(String id) {
		return super.get(id);
	}
	
	public List<TlTestSiteHotel> findList(TlTestSiteHotel tlTestSiteHotel) {
		return super.findList(tlTestSiteHotel);
	}
	
	public Page<TlTestSiteHotel> findPage(Page<TlTestSiteHotel> page, TlTestSiteHotel tlTestSiteHotel) {
		return super.findPage(page, tlTestSiteHotel);
	}
	
	@Transactional(readOnly = false)
	public void save(TlTestSiteHotel tlTestSiteHotel) {
		super.save(tlTestSiteHotel);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlTestSiteHotel tlTestSiteHotel) {
		super.delete(tlTestSiteHotel);
	}
	
}