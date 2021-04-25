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
 * 测试道路请求Entity
 * @author sunlifeng
 * @version 2020-05-14
 */
public class TlRequestTestRoad extends DataEntity<TlRequestTestRoad> {
	
	private static final long serialVersionUID = 1L;
	private String projectId;		// 项目id
	private String testRoad;		// 测试道路
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private Integer carCount;
	
	private String projectName;
	
	private String selects;
	
	public TlRequestTestRoad() {
		super();
	}

	public TlRequestTestRoad(String id){
		super(id);
	}

	@Length(min=0, max=64, message="项目id长度必须介于 0 和 64 之间")
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

	public String getSelects() {
		return selects;
	}

	public void setSelects(String selects) {
		this.selects = selects;
	}

	public Integer getCarCount() {
		return carCount;
	}

	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}