/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 试验项目管理Entity
 * @author wangqi
 * @version 2019-12-31
 */
public class TlTestprojectChild extends DataEntity<TlTestprojectChild> {
	
	private static final long serialVersionUID = 1L;
	private String tlTestprojectId;		// tl_testproject主表id
	private Integer testRoad;		// 测试道路
	private String carTime;		// 总车时数
	private String briefDescription;		// 测试简要描述
	private String limitSpeed;		// 最高测试车速
	private String carLimNum;		// 同时测试车辆数量
	
	public TlTestprojectChild() {
		super();
	}

	public TlTestprojectChild(String id){
		super(id);
	}

	@Length(min=1, max=64, message="tl_testproject主表id长度必须介于 1 和 64 之间")
	public String getTlTestprojectId() {
		return tlTestprojectId;
	}

	public void setTlTestprojectId(String tlTestprojectId) {
		this.tlTestprojectId = tlTestprojectId;
	}
	
	@NotNull( message="测试道路长度必须介于 1 和 10 之间")
	public Integer getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(Integer testRoad) {
		this.testRoad = testRoad;
	}
	
	@Length(min=1, max=16, message="总车时数长度必须介于 1 和 16 之间")
	public String getCarTime() {
		return carTime;
	}

	public void setCarTime(String carTime) {
		this.carTime = carTime;
	}
	
	@Length(min=1, max=200, message="测试简要描述长度必须介于 1 和 200 之间")
	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	
	@Length(min=1, max=16, message="最高测试车速长度必须介于 1 和 16 之间")
	public String getLimitSpeed() {
		return limitSpeed;
	}

	public void setLimitSpeed(String limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
	
	@Length(min=1, max=16, message="同时测试车辆数量长度必须介于 1 和 16 之间")
	public String getCarLimNum() {
		return carLimNum;
	}

	public void setCarLimNum(String carLimNum) {
		this.carLimNum = carLimNum;
	}
	
}