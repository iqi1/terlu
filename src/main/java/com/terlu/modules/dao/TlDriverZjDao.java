/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlDriverZj;

/**
 * 驾驶员证件DAO接口
 * @author wangqi
 * @version 2020-06-02
 */
@MyBatisDao
public interface TlDriverZjDao extends CrudDao<TlDriverZj> {
	
}