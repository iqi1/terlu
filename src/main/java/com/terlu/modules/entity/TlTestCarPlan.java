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
 * 测试车俩 计划Entity
 * @author sunlifeng
 * @version 2020-05-14
 */
public class TlTestCarPlan extends DataEntity<TlTestCarPlan> {
	
	private static final long serialVersionUID = 1L;
	private String testRoad;		// 测试道路
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private Integer carCount;		// 同时测试数量
	
	public TlTestCarPlan() {
		super();
	}

	public TlTestCarPlan(String id){
		super(id);
	}

	@Length(min=1, max=10, message="测试道路长度必须介于 1 和 10 之间")
	public String getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(String testRoad) {
		this.testRoad = testRoad;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="开始时间不能为空")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="结束时间不能为空")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	//@Length(min=1, max=8, message="同时测试数量长度必须介于 1 和 8 之间")
	public Integer getCarCount() {
		return carCount;
	}

	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}
	
}