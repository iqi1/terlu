/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 进出记录Entity
 * @author wangqi
 * @version 2020-01-14
 */
public class TlInOutRecord extends DataEntity<TlInOutRecord> {
	
	private static final long serialVersionUID = 1L;
	private String roadGateId;		// 闸机id
	private String cardId;		// 卡号id
	private String driverId;		// 驾驶员
	private String inOut;		// 进/出
	private String roadGateNum;
	private String cardNum;
	private String driverName;
	
	public TlInOutRecord() {
		super();
	}

	public TlInOutRecord(String id){
		super(id);
	}

	@Length(min=1, max=64, message="闸机id长度必须介于 1 和 64 之间")
	public String getRoadGateId() {
		return roadGateId;
	}

	public void setRoadGateId(String roadGateId) {
		this.roadGateId = roadGateId;
	}
	
	@Length(min=1, max=64, message="卡号id长度必须介于 1 和 64 之间")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@Length(min=1, max=200, message="驾驶员长度必须介于 1 和 200 之间")
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	@Length(min=1, max=4, message="进/出长度必须介于 1 和 4 之间")
	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getRoadGateNum() {
		return roadGateNum;
	}

	public void setRoadGateNum(String roadGateNum) {
		this.roadGateNum = roadGateNum;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
}