/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.terlu.modules.entity.TlDriverCard;

/**
 * 驾驶员身份证DAO接口
 * @author wangqi
 * @version 2020-06-03
 */
@MyBatisDao
public interface TlDriverCardDao extends CrudDao<TlDriverCard> {
	
}