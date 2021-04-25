/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.Length(min=0, max=16, message="单价;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 加油申请Entity
 * @author wangqi
 * @version 2020-02-05
 */
public class TlFuelManage extends DataEntity<TlFuelManage> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;	//父id	
	private String project;		// 测试项目
	private String leadTester;		// 申请人
	private String fuelType;		// 燃料类型
	private String consume;		// 加油量
	private String procInsId;	// 流程实例
	private Integer status;		// 审批状态
	private String procName;
	
	private String  companyName;
	private Integer testRoad;
	
	public TlFuelManage() {
		super();
	}

	public TlFuelManage(String id){
		super(id);
	}

	
	
	@Length(min=1, max=64, message="申请人长度必须介于 1 和 64 之间")
	public String getLeadTester() {
		return leadTester;
	}

	public void setLeadTester(String leadTester) {
		this.leadTester = leadTester;
	}
	
//	@Length(min=1, max=64, message="驾驶员长度必须介于 1 和 64 之间")
//	public String getDriver() {
//		return driver;
//	}
//
//	public void setDriver(String driver) {
//		this.driver = driver;
//	}
	
	@Length(min=1, max=8, message="燃料类型长度必须介于 1 和 8 之间")
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
//	@Length(min=1, max=16, message="加油量长度必须介于 1 和 16 之间")
	public String getConsume() {
		return consume;
	}

	public void setConsume(String consume) {
		this.consume = consume;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getTestRoad() {
		return testRoad;
	}

	public void setTestRoad(Integer testRoad) {
		this.testRoad = testRoad;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	
	
	
}