/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlTestRoomReservationChild;

/**
 * 测试包场预定DAO接口
 * @author wangqi
 * @version 2019-12-30
 */
@MyBatisDao
public interface TlTestRoomReservationChildDao extends CrudDao<TlTestRoomReservationChild> {
	
}