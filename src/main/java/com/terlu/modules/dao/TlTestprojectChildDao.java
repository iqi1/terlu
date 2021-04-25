/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlTestprojectChild;

/**
 * 测试项目DAO接口
 * @author sunlifeng
 * @version 2019-12-27
 */
@MyBatisDao
public interface TlTestprojectChildDao extends CrudDao<TlTestprojectChild> {
	
}