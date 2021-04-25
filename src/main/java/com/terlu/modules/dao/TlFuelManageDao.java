/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlFuelManage;

/**
 * 加油申请DAO接口
 * @author wangqi
 * @version 2020-02-05
 */
@MyBatisDao
public interface TlFuelManageDao extends CrudDao<TlFuelManage> {
	
}