/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 闸机信息Entity
 * @author wangqi
 * @version 2020-01-10
 */
public class TlRoadGate extends DataEntity<TlRoadGate> {
	
	private static final long serialVersionUID = 1L;
	private String gateNum;		// 闸机编号
	private String deviceNum;		// 设备编号
//	private String inOutRecord;		// 进出记录
//	private String cardRecord;		// 卡记录
//	private Date comeDate;		// 进场时间
//	private Date outDate;		// 出场时间
	private String roadGateNum;
	
	public TlRoadGate() {
		super();
	}

	public TlRoadGate(String id){
		super(id);
	}

	@Length(min=1, max=32, message="闸机编号长度必须介于 1 和 32 之间")
	public String getGateNum() {
		return gateNum;
	}

	public void setGateNum(String gateNum) {
		this.gateNum = gateNum;
	}
	
	@Length(min=1, max=32, message="设备编号长度必须介于 1 和 32 之间")
	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getRoadGateNum() {
		return roadGateNum;
	}

	public void setRoadGateNum(String roadGateNum) {
		this.roadGateNum = roadGateNum;
	}
	
//	@Length(min=1, max=1, message="进出记录长度必须介于 1 和 1 之间")
//	public String getInOutRecord() {
//		return inOutRecord;
//	}
//
//	public void setInOutRecord(String inOutRecord) {
//		this.inOutRecord = inOutRecord;
//	}
	
//	@Length(min=1, max=64, message="卡记录长度必须介于 1 和 64 之间")
//	public String getCardRecord() {
//		return cardRecord;
//	}
//
//	public void setCardRecord(String cardRecord) {
//		this.cardRecord = cardRecord;
//	}
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="进场时间不能为空")
//	public Date getComeDate() {
//		return comeDate;
//	}
//
//	public void setComeDate(Date comeDate) {
//		this.comeDate = comeDate;
//	}
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="出场时间不能为空")
//	public Date getOutDate() {
//		return outDate;
//	}
//
//	public void setOutDate(Date outDate) {
//		this.outDate = outDate;
//	}
	
}