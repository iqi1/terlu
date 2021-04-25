/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlSendAddress;
import com.terlu.modules.dao.TlSendAddressDao;

/**
 * 寄送信息登记Service
 * @author wangqi
 * @version 2020-01-02
 */
@Service
@Transactional(readOnly = true)
public class TlSendAddressService extends CrudService<TlSendAddressDao, TlSendAddress> {

	public TlSendAddress get(String id) {
		return super.get(id);
	}
	
	public List<TlSendAddress> findList(TlSendAddress tlSendAddress) {
		return super.findList(tlSendAddress);
	}
	
	public Page<TlSendAddress> findPage(Page<TlSendAddress> page, TlSendAddress tlSendAddress) {
		return super.findPage(page, tlSendAddress);
	}
	
	@Transactional(readOnly = false)
	public void save(TlSendAddress tlSendAddress) {
		super.save(tlSendAddress);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlSendAddress tlSendAddress) {
		super.delete(tlSendAddress);
	}
	
}