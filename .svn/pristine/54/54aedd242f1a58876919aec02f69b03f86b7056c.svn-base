/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 油/电卡Entity
 * @author wangqi
 * @version 2020-02-10
 */
public class TlFuelchargeCard extends DataEntity<TlFuelchargeCard> {
	
	private static final long serialVersionUID = 1L;
	private String cardNum;		// 卡号
	private String quantity;		// 数量
	
	public TlFuelchargeCard() {
		super();
	}

	public TlFuelchargeCard(String id){
		super(id);
	}

	@Length(min=1, max=64, message="卡号长度必须介于 1 和 64 之间")
	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	@Length(min=1, max=16, message="数量长度必须介于 1 和 16 之间")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}