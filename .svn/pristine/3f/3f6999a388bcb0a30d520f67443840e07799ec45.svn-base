/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 试验任务单Entity
 * @author sunlifeng
 * @version 2020-01-06
 */
public class TlTestTaskList extends DataEntity<TlTestTaskList> {
	
	private static final long serialVersionUID = 1L;
	
	private String projectId;		// 项目编号
	//private User user;		// 驾驶员
	private Integer isBaoChang = new Integer(0);
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private String driverId;
	private String driverName;
	
	private Integer testRoad;
	private String  companyName;
	
	private String  userId;
	private String  parentId;
	
	private Integer isModify;
	
	public TlTestTaskList() {
		super();
		isModify = new Integer(1);
	}

	public TlTestTaskList(String id){
		super(id);
		isModify = new Integer(1);
	}

	@Length(min=1, max=64, message="项目编号长度必须介于 1 和 64 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
//	@NotNull(message="驾驶员不能为空")
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
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

	@NotNull(message="是否包场不能为空")
	public Integer getIsBaoChang() {
		return isBaoChang;
	}

	public void setIsBaoChang(Integer isBaoChang) {
		this.isBaoChang = isBaoChang;
	}

	public Integer getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(Integer testRoad) {
		this.testRoad = testRoad;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getIsModify() {
		return isModify;
	}

	public void setIsModify(Integer isModify) {
		this.isModify = isModify;
	}
	
}