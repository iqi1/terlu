/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlTestCarPlan;

/**
 * 测试车俩 计划DAO接口
 * @author sunlifeng
 * @version 2020-05-14
 */
@MyBatisDao
public interface TlTestCarPlanDao extends CrudDao<TlTestCarPlan> {
	
}