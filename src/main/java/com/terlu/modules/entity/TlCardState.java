/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 卡状态Entity
 * @author wangqi
 * @version 2020-01-14
 */
public class TlCardState extends DataEntity<TlCardState> {
	
	private static final long serialVersionUID = 1L;
	private String driverId;		// 驾驶员id,has/no对应cardrecordbiao
	private String cardId;		// 卡号id
	private String parentId;	//父id
	private String driverName;
	private String cardNum;
	
	public TlCardState() {
		super();
	}

	public TlCardState(String id){
		super(id);
	}

//	@Length(min=0, max=64, message="驾驶员id,has/no长度必须介于 0 和 64 之间")
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
//	@Length(min=1, max=18, message="卡号id长度必须介于 1 和 18 之间")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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