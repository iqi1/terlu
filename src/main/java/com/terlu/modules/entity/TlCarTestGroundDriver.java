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
 * 驾驶员管理Entity
 * @author wangqi
 * @version 2020-01-08
 */
public class TlCarTestGroundDriver extends DataEntity<TlCarTestGroundDriver> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String telephoneDriver;		// 联系电话
	private String idcardPassport;		// 身份证号
	private String driverLicenseNum;		// 驾驶证号
	private Date firstLicenseTime;		// 初次领取驾照日期
	private String householdRegister;		// 户籍
	private byte[] driverPhoto;		// 司机照片
	private String health;		// 健康状况
	private String badRecord;		// 不良记录
	private String recordBelow12;		// 是否记满12分
	private String ispassExam;		// 是否通过考试
	
	public TlCarTestGroundDriver() {
		super();
	}

	public TlCarTestGroundDriver(String id){
		super(id);
	}

	@Length(min=1, max=64, message="姓名长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=15, message="联系电话长度必须介于 1 和 15 之间")
	public String getTelephoneDriver() {
		return telephoneDriver;
	}

	public void setTelephoneDriver(String telephoneDriver) {
		this.telephoneDriver = telephoneDriver;
	}
	
	@Length(min=1, max=18, message="身份证号长度必须介于 1 和 18 之间")
	public String getIdcardPassport() {
		return idcardPassport;
	}

	public void setIdcardPassport(String idcardPassport) {
		this.idcardPassport = idcardPassport;
	}
	
	@Length(min=1, max=18, message="驾驶证号长度必须介于 1 和 18 之间")
	public String getDriverLicenseNum() {
		return driverLicenseNum;
	}

	public void setDriverLicenseNum(String driverLicenseNum) {
		this.driverLicenseNum = driverLicenseNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="初次领取驾照日期不能为空")
	public Date getFirstLicenseTime() {
		return firstLicenseTime;
	}

	public void setFirstLicenseTime(Date firstLicenseTime) {
		this.firstLicenseTime = firstLicenseTime;
	}
	
	@Length(min=0, max=64, message="户籍长度必须介于 0 和 64 之间")
	public String getHouseholdRegister() {
		return householdRegister;
	}

	public void setHouseholdRegister(String householdRegister) {
		this.householdRegister = householdRegister;
	}

	public byte[] getDriverPhoto() {
		return driverPhoto;
	}

	public void setDriverPhoto(byte[] driverPhoto) {
		this.driverPhoto = driverPhoto;
	}

	@Length(min=1, max=16, message="健康状况长度必须介于 1 和 16 之间")
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}
	
	@Length(min=1, max=16, message="不良记录长度必须介于 1 和 16 之间")
	public String getBadRecord() {
		return badRecord;
	}

	public void setBadRecord(String badRecord) {
		this.badRecord = badRecord;
	}
	
	@Length(min=1, max=1, message="是否记满12分长度必须介于 1 和 1 之间")
	public String getRecordBelow12() {
		return recordBelow12;
	}

	public void setRecordBelow12(String recordBelow12) {
		this.recordBelow12 = recordBelow12;
	}
	
	@Length(min=1, max=1, message="是否通过考试长度必须介于 1 和 1 之间")
	public String getIspassExam() {
		return ispassExam;
	}

	public void setIspassExam(String ispassExam) {
		this.ispassExam = ispassExam;
	}

}