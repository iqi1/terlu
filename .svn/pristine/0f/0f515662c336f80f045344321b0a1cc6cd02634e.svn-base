/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 到访人员信息登记Entity
 * @author sunlifeng
 * @version 2019-12-30
 */
public class TlVistorRegister extends DataEntity<TlVistorRegister> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private String name;		// 姓名
	private String idcardPassport;		// 身份证/护照
	private Integer driver;		// 是否为试验驾驶员
	private Integer applyLicense;		// 是否申请试验场驾驶许可证
	private Integer joinSafetrain;		// 是否参加安全简介培训
	private Integer checkinHotel;		// 是否入住试验场酒店
	
	public TlVistorRegister() {
		super();
	}

	public TlVistorRegister(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父id不能为空")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	@Length(min=1, max=64, message="姓名长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=24, message="身份证/护照长度必须介于 1 和 24 之间")
	public String getIdcardPassport() {
		return idcardPassport;
	}

	public void setIdcardPassport(String idcardPassport) {
		this.idcardPassport = idcardPassport;
	}
	
	//@Length(min=1, max=1, message="是否为试验驾驶员长度必须介于 1 和 1 之间")
	@NotNull(message="是否为试验驾驶员不能为空")
	public Integer getDriver() {
		return driver;
	}

	public void setDriver(Integer driver) {
		this.driver = driver;
	}
	
	//@Length(min=1, max=1, message="是否申请试验场驾驶许可证长度必须介于 1 和 1 之间")
	@NotNull(message="是否申请试验场驾驶许可证不能为空")
	public Integer getApplyLicense() {
		return applyLicense;
	}

	public void setApplyLicense(Integer applyLicense) {
		this.applyLicense = applyLicense;
	}
	
	//@Length(min=1, max=1, message="是否参加安全简介培训长度必须介于 1 和 1 之间")
	@NotNull(message="是否参加安全简介培训不能为空")
	public Integer getJoinSafetrain() {
		return joinSafetrain;
	}

	public void setJoinSafetrain(Integer joinSafetrain) {
		this.joinSafetrain = joinSafetrain;
	}
	
	//@Length(min=0, max=1, message="是否入住试验场酒店长度必须介于 0 和 1 之间")
	public Integer getCheckinHotel() {
		return checkinHotel;
	}

	public void setCheckinHotel(Integer checkinHotel) {
		this.checkinHotel = checkinHotel;
	}
	
}