/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 动态获取设备使用记录Entity
 * @author wangqi
 * @version 2020-05-12
 */
public class TlDynamicGetEq extends DataEntity<TlDynamicGetEq> {
	
	private static final long serialVersionUID = 1L;
	private String startPlace;		// 开始地点
	private String endPlace;		// 结束地点
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private String bindCar;		// 绑定车辆
	
	public TlDynamicGetEq() {
		super();
	}

	public TlDynamicGetEq(String id){
		super(id);
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	
	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
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
	
	@Length(min=1, max=64, message="绑定车辆长度必须介于 1 和 64 之间")
	public String getBindCar() {
		return bindCar;
	}

	public void setBindCar(String bindCar) {
		this.bindCar = bindCar;
	}
	
}