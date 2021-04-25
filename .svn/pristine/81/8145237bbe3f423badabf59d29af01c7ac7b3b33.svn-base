/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.terlu.modules.entity.TlRequestTestRoad;
import com.terlu.modules.dao.TlRequestTestRoadDao;

/**
 * 测试道路请求Service
 * @author sunlifeng
 * @version 2020-05-14
 */
@Service
@Transactional(readOnly = true)
public class TlRequestTestRoadService extends CrudService<TlRequestTestRoadDao, TlRequestTestRoad> {
	

	public TlRequestTestRoad get(String id) {
		return super.get(id);
	}
	
	public List<TlRequestTestRoad> findList(TlRequestTestRoad tlRequestTestRoad) {
		return super.findList(tlRequestTestRoad);
	}
	
	public Page<TlRequestTestRoad> findPage(Page<TlRequestTestRoad> page, TlRequestTestRoad tlRequestTestRoad) {
		return super.findPage(page, tlRequestTestRoad);
	}
	
	@Transactional(readOnly = false)
	public void save(TlRequestTestRoad tlRequestTestRoad) {
		super.save(tlRequestTestRoad);
	}
	
	@Transactional(readOnly = false)
	public void delete(TlRequestTestRoad tlRequestTestRoad) {
		super.delete(tlRequestTestRoad);
	}

	@Transactional(readOnly = false)
	public void saveList(List<TlRequestTestRoad> list, List<TlRequestTestRoad> listUpdata) {
		if(list.size() > 0)
			dao.insertList(list);
		if(listUpdata.size() > 0)	
		{
			dao.updateList(listUpdata);
			//for(TlRequestTestRoad tlRequestTestRoad : listUpdata)
			//	dao.update(tlRequestTestRoad);
		}
	}

	public List<TlRequestTestRoad> findListFor(TlRequestTestRoad tlRequestTestRoad) {
		return dao.findListFor(tlRequestTestRoad);
	}
	
}