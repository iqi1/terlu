/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 卡记录Entity
 * @author wangqi
 * @version 2020-01-14
 */
public class TlCardRecord extends DataEntity<TlCardRecord> {
	
	private static final long serialVersionUID = 1L;
	private String driverId;		// 驾驶员id
	private String cardNum;		// 卡号
	private String state;		// 已领/未领
	private String driverName;
	
	public TlCardRecord() {
		super();
	}

	public TlCardRecord(String id){
		super(id);
	}

//	@Length(min=1, max=64, message="驾驶员id长度必须介于 1 和 64 之间")
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	@Length(min=1, max=18, message="卡号长度必须介于 1 和 18 之间")
	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	@Length(min=1, max=4, message="已领/未领长度必须介于 1 和 4 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
}