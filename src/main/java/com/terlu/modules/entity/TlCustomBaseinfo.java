/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 试验测试申请表Entity
 * @author sunlifeng
 * @version 2019-12-27
 */
public class TlCustomBaseinfo extends DataEntity<TlCustomBaseinfo> {
	
	private static final long serialVersionUID = 1L;
	private String companyName;		// 公司名称
	private String weekId;
	private String weekName;
	
	private Date startDate;		// 测试开始日期
	private Date endDate;		// 测试结束日期
	private String address;		// 地址
	private String department;		// 部门
	private String telephone;		// 电话
	private String zipCode;		// 邮编
	private String fax;		// 传真
	private String email;		// 邮箱
	private String contactNumberL;		// 项目负责人联系电话
	private String emailL;		// 项目负责人邮箱
	private String contactNumberC;		// 项目联系人联系电话
	private String emailC;		// 项目联系人邮箱
	private User userLeader;//领队试验员
	private User userAuthorizer;//项目负责人
	
	private Integer status;		// 审批状态
	private String procInsId;	// 流程实例
	private String procName;
	
	private String marketId;
	private String fieldId;
	
	private String comment;
	
	public TlCustomBaseinfo() {
		super();
	}

	public TlCustomBaseinfo(String id){
		super(id);
	}
	

	@Length(min=1, max=100, message="公司名称长度必须介于 1 和 100 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="测试开始日期不能为空")
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="测试结束日期不能为空")
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=32, message="部门长度必须介于 0 和 32 之间")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=1, max=15, message="电话长度必须介于 1 和 15 之间")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=0, max=10, message="邮编长度必须介于 0 和 10 之间")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Length(min=0, max=20, message="传真长度必须介于 0 和 20 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=1, max=32, message="邮箱长度必须介于 1 和 32 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=1, max=15, message="项目负责人联系电话长度必须介于 1 和 15 之间")
	public String getContactNumberL() {
		return contactNumberL;
	}

	public void setContactNumberL(String contactNumberL) {
		this.contactNumberL = contactNumberL;
	}
	
	@Length(min=0, max=64, message="项目负责人邮箱长度必须介于 0 和 64 之间")
	public String getEmailL() {
		return emailL;
	}

	public void setEmailL(String emailL) {
		this.emailL = emailL;
	}
	
	@Length(min=1, max=15, message="项目联系人联系电话长度必须介于 1 和 15 之间")
	public String getContactNumberC() {
		return contactNumberC;
	}

	public void setContactNumberC(String contactNumberC) {
		this.contactNumberC = contactNumberC;
	}
	
	@Length(min=0, max=64, message="项目联系人邮箱长度必须介于 0 和 64 之间")
	public String getEmailC() {
		return emailC;
	}

	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}

	public User getUserAuthorizer() {
		return userAuthorizer;
	}

	public void setUserAuthorizer(User userAuthorizer) {
		this.userAuthorizer = userAuthorizer;
	}

	public User getUserLeader() {
		return userLeader;
	}

	public void setUserLeader(User userLeader) {
		this.userLeader = userLeader;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getWeekId() {
		return weekId;
	}

	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	
}