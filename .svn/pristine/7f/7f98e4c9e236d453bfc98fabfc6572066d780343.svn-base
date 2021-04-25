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
 * 驾驶员资质Entity
 * @author wangqi
 * @version 2020-02-19
 */
public class TlDriverQualification extends DataEntity<TlDriverQualification> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String sex;		// 性别
	private String idCard;		// 身份证号
	private String eduLevel;		// 文化程度
	private Date issueDate;		// 发证日期
	private String certificateNum;		// 证书编号
	private String occupation;		// 职业(工种)及等级
	private String theoryResult;		// 理论知识考试成绩
	private String skillResult;		// 操作技能考试成绩
	private String multipleResult;		// 综合评审成绩
	private String evaluateResult;		// 评定成绩
	
	public TlDriverQualification() {
		super();
	}

	public TlDriverQualification(String id){
		super(id);
	}

	@Length(min=1, max=50, message="姓名长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=1, message="性别长度必须介于 1 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=18, message="身份证号长度必须介于 1 和 18 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=1, max=4, message="文化程度长度必须介于 1 和 4 之间")
	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发证日期不能为空")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Length(min=1, max=64, message="证书编号长度必须介于 1 和 64 之间")
	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	
	@Length(min=1, max=50, message="职业(工种)及等级长度必须介于 1 和 50 之间")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@Length(min=1, max=7, message="理论知识考试成绩长度必须介于 1 和 7 之间")
	public String getTheoryResult() {
		return theoryResult;
	}

	public void setTheoryResult(String theoryResult) {
		this.theoryResult = theoryResult;
	}
	
	@Length(min=1, max=7, message="操作技能考试成绩长度必须介于 1 和 7 之间")
	public String getSkillResult() {
		return skillResult;
	}

	public void setSkillResult(String skillResult) {
		this.skillResult = skillResult;
	}
	
	@Length(min=1, max=7, message="综合评审成绩长度必须介于 1 和 7 之间")
	public String getMultipleResult() {
		return multipleResult;
	}

	public void setMultipleResult(String multipleResult) {
		this.multipleResult = multipleResult;
	}
	
	@Length(min=1, max=7, message="评定成绩长度必须介于 1 和 7 之间")
	public String getEvaluateResult() {
		return evaluateResult;
	}

	public void setEvaluateResult(String evaluateResult) {
		this.evaluateResult = evaluateResult;
	}
	
}