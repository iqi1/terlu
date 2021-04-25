/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlWeekScheduleDetails;

/**
 * 计划排班DAO接口
 * @author sunlifeng
 * @version 2020-05-13
 */
@MyBatisDao
public interface TlWeekScheduleDetailsDao extends CrudDao<TlWeekScheduleDetails> {
	
}