/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlStaticWriteEq;

/**
 * 静态录入设备信息表DAO接口
 * @author wangqi
 * @version 2020-05-12
 */
@MyBatisDao
public interface TlStaticWriteEqDao extends CrudDao<TlStaticWriteEq> {
	
}