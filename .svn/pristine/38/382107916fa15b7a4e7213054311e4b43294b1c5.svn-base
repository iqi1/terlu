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
 * 定位轨迹Entity
 * @author wangqi
 * @version 2020-05-06
 */
public class TlGpsTrail extends DataEntity<TlGpsTrail> {
	
	private static final long serialVersionUID = 1L;
	private String eid;		// 设备编号
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private String mileage;		// 里程
	private String testRoad;		// 测试道路
	
	public TlGpsTrail() {
		super();
	}

	public TlGpsTrail(String id){
		super(id);
	}

	@Length(min=1, max=64, message="设备编号长度必须介于 1 和 64 之间")
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
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
	
	@Length(min=1, max=64, message="里程长度必须介于 1 和 64 之间")
	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	@Length(min=1, max=10, message="测试道路长度必须介于 1 和 10 之间")
	public String getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(String testRoad) {
		this.testRoad = testRoad;
	}
	
}