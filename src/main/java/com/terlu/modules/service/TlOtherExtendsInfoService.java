/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlOtherExtendsInfo;
import com.terlu.modules.dao.TlOtherExtendsInfoDao;

/**
 * 其他扩展信息Service
 * @author wangqi
 * @version 2020-01-02
 */
@Service
@Transactional(readOnly = true)
public class TlOtherExtendsInfoService extends CrudService<TlOtherExtendsInfoDao, TlOtherExtendsInfo> {

	public TlOtherExtendsInfo get(String id) {
		return super.get(id);
	}
	
	public List<TlOtherExtendsInfo> findList(TlOtherExtendsInfo tlOtherExtendsInfo) {
		return super.findList(tlOtherExtendsInfo);
	}
	
	public Page<TlOtherExtendsInfo> findPage(Page<TlOtherExtendsInfo> page, TlOtherExtendsInfo tlOtherExtendsInfo) {
		return super.findPage(page, tlOtherExtendsInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TlOtherExtendsInfo tlOtherExtendsInfo) {
		super.save(tlOtherExtendsInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlOtherExtendsInfo tlOtherExtendsInfo) {
		super.delete(tlOtherExtendsInfo);
	}
	
}