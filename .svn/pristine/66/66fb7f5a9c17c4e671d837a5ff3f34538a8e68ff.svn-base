/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 场地控制Entity
 * @author wangqi
 * @version 2020-01-10
 */
public class TlMidRoadGate extends DataEntity<TlMidRoadGate> {
	
	private static final long serialVersionUID = 1L;
	private String tlRoadGateId;		// 闸机id
	private String testRoad;		// 测试道路
	private String roadGateNum;
	private Integer charge;			//计费字段按小时计费
	private Integer kmCharge;		//按公里计费
	
	public TlMidRoadGate() {
		super();
	}

	public TlMidRoadGate(String id){
		super(id);
	}

	@Length(min=1, max=64, message="闸机id长度必须介于 1 和 64 之间")
	public String getTlRoadGateId() {
		return tlRoadGateId;
	}

	public void setTlRoadGateId(String tlRoadGateId) {
		this.tlRoadGateId = tlRoadGateId;
	}
	
	@Length(min=1, max=10, message="测试道路长度必须介于 1 和 10 之间")
	public String getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(String testRoad) {
		this.testRoad = testRoad;
	}

	public String getRoadGateNum() {
		return roadGateNum;
	}

	public void setRoadGateNum(String roadGateNum) {
		this.roadGateNum = roadGateNum;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public Integer getKmCharge() {
		return kmCharge;
	}

	public void setKmCharge(Integer kmCharge) {
		this.kmCharge = kmCharge;
	}
	
}