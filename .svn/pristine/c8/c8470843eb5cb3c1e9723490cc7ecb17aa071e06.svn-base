/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 周计划附表Entity
 * @author wangqi
 * @version 2020-05-08
 */
public class TlWeekSchedule extends DataEntity<TlWeekSchedule> {
	
	private static final long serialVersionUID = 1L;
	private String msid;
	private String testTime;		// 测试时长
	private String carNum;		// 车辆数
	private String testRoad;		// 测试道路
	private String mid;
	
	public TlWeekSchedule() {
		super();
	}

	public TlWeekSchedule(String id){
		super(id);
	}

	public String getMsid() {
		return msid;
	}
	
	public void setMsid(String msid) {
		this.msid = msid;
	}
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	
	@Length(min=1, max=16, message="车辆数长度必须介于 1 和 16 之间")
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	@Length(min=1, max=10, message="测试道路长度必须介于 1 和 10 之间")
	public String getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(String testRoad) {
		this.testRoad = testRoad;
	}
	
}