/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlTestRoomReservationChild;
import com.terlu.modules.dao.TlTestRoomReservationChildDao;

/**
 * 测试包场预定Service
 * @author wangqi
 * @version 2019-12-30
 */
@Service
@Transactional(readOnly = true)
public class TlTestRoomReservationChildService extends CrudService<TlTestRoomReservationChildDao, TlTestRoomReservationChild> {

	public TlTestRoomReservationChild get(String id) {
		return super.get(id);
	}
	
	public List<TlTestRoomReservationChild> findList(TlTestRoomReservationChild tlTestRoomReservationChild) {
		return super.findList(tlTestRoomReservationChild);
	}
	
	public Page<TlTestRoomReservationChild> findPage(Page<TlTestRoomReservationChild> page, TlTestRoomReservationChild tlTestRoomReservationChild) {
		return super.findPage(page, tlTestRoomReservationChild);
	}
	
	@Transactional(readOnly = false)
	public void save(TlTestRoomReservationChild tlTestRoomReservationChild) {
		super.save(tlTestRoomReservationChild);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlTestRoomReservationChild tlTestRoomReservationChild) {
		super.delete(tlTestRoomReservationChild);
	}
	
}