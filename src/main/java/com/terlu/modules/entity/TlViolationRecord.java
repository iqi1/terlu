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
 * 违规记录Entity
 * @author wangqi
 * @version 2020-01-08
 */
public class TlViolationRecord extends DataEntity<TlViolationRecord> {
	
	private static final long serialVersionUID = 1L;
	private String driverName;		// 驾驶员姓名
	private String telephone;		// 联系电话
	private String violationRecord;		// 违规记录
	private Date violationTime;		// 违规时间
	
	public TlViolationRecord() {
		super();
	}

	public TlViolationRecord(String id){
		super(id);
	}

	@Length(min=1, max=32, message="驾驶员姓名长度必须介于 1 和 32 之间")
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	@Length(min=1, max=15, message="联系电话长度必须介于 1 和 15 之间")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=1, max=32, message="违规记录长度必须介于 1 和 32 之间")
	public String getViolationRecord() {
		return violationRecord;
	}

	public void setViolationRecord(String violationRecord) {
		this.violationRecord = violationRecord;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="违规时间不能为空")
	public Date getViolationTime() {
		return violationTime;
	}

	public void setViolationTime(Date violationTime) {
		this.violationTime = violationTime;
	}
	
}