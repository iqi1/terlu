/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlCarInfo;

/**
 * 车辆信息登记DAO接口
 * @author wangqi
 * @version 2019-12-30
 */
@MyBatisDao
public interface TlCarInfoDao extends CrudDao<TlCarInfo> {
	
}