/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 设备分配表Entity
 * @author wangqi
 * @version 2020-05-06
 */
public class TlEquDis extends DataEntity<TlEquDis> {
	
	private static final long serialVersionUID = 1L;
	private String eid;		// 设备编号
	
	public TlEquDis() {
		super();
	}

	public TlEquDis(String id){
		super(id);
	}

	@Length(min=1, max=64, message="设备编号长度必须介于 1 和 64 之间")
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
	
}