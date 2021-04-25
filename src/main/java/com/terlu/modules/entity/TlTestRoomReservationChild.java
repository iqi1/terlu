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
 * 测试包场预定Entity
 * @author wangqi
 * @version 2019-12-31
 */
public class TlTestRoomReservationChild extends DataEntity<TlTestRoomReservationChild> {
	
	private static final long serialVersionUID = 1L;
	private String tlCustomBaseinfoId;		// 父id
	private String tlTestRoomReservationId;		// 测试包场预定主表id
	private Integer testRoad;		// 测试道路
	private Date packageDate;		// 包场日期
	private String packageTime;		// 包场时间
	private String carLimNum;		// 同时使用场地车辆数目
	
	public TlTestRoomReservationChild() {
		super();
	}

	public TlTestRoomReservationChild(String id){
		super(id);
	}

	@Length(min=1, max=64, message="父id长度必须介于 1 和 64 之间")
	public String getTlCustomBaseinfoId() {
		return tlCustomBaseinfoId;
	}

	public void setTlCustomBaseinfoId(String tlCustomBaseinfoId) {
		this.tlCustomBaseinfoId = tlCustomBaseinfoId;
	}
	
	@Length(min=0, max=64, message="测试包场预定主表id长度必须介于 0 和 64 之间")
	public String getTlTestRoomReservationId() {
		return tlTestRoomReservationId;
	}

	public void setTlTestRoomReservationId(String tlTestRoomReservationId) {
		this.tlTestRoomReservationId = tlTestRoomReservationId;
	}
	
	@NotNull(message="测试道路不能为空")
	public Integer getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(Integer testRoad) {
		this.testRoad = testRoad;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="包场日期不能为空")
	public Date getPackageDate() {
		return packageDate;
	}

	public void setPackageDate(Date packageDate) {
		this.packageDate = packageDate;
	}
	
	@Length(min=1, max=16, message="包场时间长度必须介于 1 和 16 之间")
	public String getPackageTime() {
		return packageTime;
	}

	public void setPackageTime(String packageTime) {
		this.packageTime = packageTime;
	}
	
	@Length(min=1, max=32, message="同时使用场地车辆数目长度必须介于 1 和 32 之间")
	public String getCarLimNum() {
		return carLimNum;
	}

	public void setCarLimNum(String carLimNum) {
		this.carLimNum = carLimNum;
	}
	
}