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
 * 计划排班Entity
 * @author sunlifeng
 * @version 2020-05-13
 */
public class TlWeekScheduleDetails extends DataEntity<TlWeekScheduleDetails> {
	
	private static final long serialVersionUID = 1L;
	private String msid;		// 关联主表mid
	private String weekName;
	private String projectId;		// 项目id
	private String testRoad;		// 测试道路
	private Date testDate;		// 测试日期
	private String timeSeries;		// 测试时序
	
	private byte[] details;
	
	private String selects;
	
	public TlWeekScheduleDetails() {
		super();
	}

	public TlWeekScheduleDetails(String id){
		super(id);
	}

	@Length(min=1, max=64, message="关联主表mid长度必须介于 1 和 64 之间")
	public String getMsid() {
		return msid;
	}

	public void setMsid(String msid) {
		this.msid = msid;
	}
	
	//@Length(min=1, max=64, message="项目id长度必须介于 1 和 64 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Length(min=1, max=10, message="测试道路长度必须介于 1 和 10 之间")
	public String getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(String testRoad) {
		this.testRoad = testRoad;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="测试日期不能为空")
	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	@Length(min=1, max=8, message="测试时序长度必须介于 1 和 8 之间")
	public String getTimeSeries() {
		return timeSeries;
	}

	public void setTimeSeries(String timeSeries) {
		this.timeSeries = timeSeries;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	public String getSelects() {
		return selects;
	}

	public void setSelects(String selects) {
		this.selects = selects;
	}

	public byte[] getDetails() {
		return details;
	}

	public void setDetails(byte[] details) {
		this.details = details;
	}
	
}