/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 静态录入设备信息表Entity
 * @author wangqi
 * @version 2020-05-12
 */
public class TlStaticWriteEq extends DataEntity<TlStaticWriteEq> {
	
	private static final long serialVersionUID = 1L;
	private String eqNum;		// 设备编号
	private String simNum;		// SIM卡号
	private String simPayRecord;		// SIM卡缴费记录
	
	public TlStaticWriteEq() {
		super();
	}

	public TlStaticWriteEq(String id){
		super(id);
	}

	@Length(min=1, max=20, message="设备编号长度必须介于 1 和 20 之间")
	public String getEqNum() {
		return eqNum;
	}

	public void setEqNum(String eqNum) {
		this.eqNum = eqNum;
	}
	
	@Length(min=1, max=50, message="SIM卡号长度必须介于 1 和 50 之间")
	public String getSimNum() {
		return simNum;
	}

	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}
	
	@Length(min=1, max=64, message="SIM卡缴费记录长度必须介于 1 和 64 之间")
	public String getSimPayRecord() {
		return simPayRecord;
	}

	public void setSimPayRecord(String simPayRecord) {
		this.simPayRecord = simPayRecord;
	}
	
}