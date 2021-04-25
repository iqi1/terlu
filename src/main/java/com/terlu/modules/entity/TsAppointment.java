/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 试验预约Entity
 * @author sunlifeng
 * @version 2019-12-25
 */
public class TsAppointment extends DataEntity<TsAppointment> {
	
	private static final long serialVersionUID = 1L;
	private String unitName;		// 单位名称
	private String contactName;		// 联系人姓名
	private String email;		// 邮箱
	private String phone;		// 电话
	private String mobile;		// 手机
	private String sex;		// 性别
	private Date inDate;		// 加入日期
	
	public TsAppointment() {
		super();
	}

	public TsAppointment(String id){
		super(id);
	}

	@Length(min=0, max=100, message="单位名称长度必须介于 0 和 100 之间")
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Length(min=0, max=10, message="联系人姓名长度必须介于 0 和 10 之间")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	@Length(min=0, max=200, message="邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="手机长度必须介于 0 和 200 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
}