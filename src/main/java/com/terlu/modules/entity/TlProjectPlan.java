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
 * 项目计划Entity
 * @author wangqi
 * @version 2020-02-19
 */
public class TlProjectPlan extends DataEntity<TlProjectPlan> {
	
	private static final long serialVersionUID = 1L;
	private String projectCode;		// 项目编号
	private String projectName;		// 项目名称
	private String projectManager;		// 项目经理
	private String projectPatron;		// 项目出资人
	private String projectApprove;		// 项目审核人
	private String projectTarget;		// 项目目标
	private Date planBegindate;		// 项目计划开始时间
	private Date planEnddate;		// 项目计划完成时间
	private String projectStandard;		// 项目评价标准
	private String projectSchedule;		// 项目阶段性计划
	private String projectRisk;		// 项目约束条件
	private String projectStatus;		// 项目状态
	private byte[] attachment;		// 附件
	
	public TlProjectPlan() {
		super();
	}

	public TlProjectPlan(String id){
		super(id);
	}

	@Length(min=1, max=50, message="项目编号长度必须介于 1 和 50 之间")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=1, max=50, message="项目名称长度必须介于 1 和 50 之间")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=1, max=50, message="项目经理长度必须介于 1 和 50 之间")
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
	@Length(min=1, max=50, message="项目出资人长度必须介于 1 和 50 之间")
	public String getProjectPatron() {
		return projectPatron;
	}

	public void setProjectPatron(String projectPatron) {
		this.projectPatron = projectPatron;
	}
	
	@Length(min=1, max=50, message="项目审核人长度必须介于 1 和 50 之间")
	public String getProjectApprove() {
		return projectApprove;
	}

	public void setProjectApprove(String projectApprove) {
		this.projectApprove = projectApprove;
	}
	
	@Length(min=1, max=50, message="项目目标长度必须介于 1 和 50 之间")
	public String getProjectTarget() {
		return projectTarget;
	}

	public void setProjectTarget(String projectTarget) {
		this.projectTarget = projectTarget;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="项目计划开始时间不能为空")
	public Date getPlanBegindate() {
		return planBegindate;
	}

	public void setPlanBegindate(Date planBegindate) {
		this.planBegindate = planBegindate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="项目计划完成时间不能为空")
	public Date getPlanEnddate() {
		return planEnddate;
	}

	public void setPlanEnddate(Date planEnddate) {
		this.planEnddate = planEnddate;
	}
	
	@Length(min=1, max=50, message="项目评价标准长度必须介于 1 和 50 之间")
	public String getProjectStandard() {
		return projectStandard;
	}

	public void setProjectStandard(String projectStandard) {
		this.projectStandard = projectStandard;
	}
	
	@Length(min=1, max=50, message="项目阶段性计划长度必须介于 1 和 50 之间")
	public String getProjectSchedule() {
		return projectSchedule;
	}

	public void setProjectSchedule(String projectSchedule) {
		this.projectSchedule = projectSchedule;
	}
	
	@Length(min=1, max=50, message="项目约束条件长度必须介于 1 和 50 之间")
	public String getProjectRisk() {
		return projectRisk;
	}

	public void setProjectRisk(String projectRisk) {
		this.projectRisk = projectRisk;
	}
	
	@Length(min=1, max=50, message="项目状态长度必须介于 1 和 50 之间")
	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
}