/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 驾驶员能力评估Entity
 * @author wangqi
 * @version 2020-06-02
 */
public class TlDriverAblility extends DataEntity<TlDriverAblility> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String driverAge;		// 驾龄
	private String sex;		// 性别
	private String applyLevel;		// 申请等级
	private String experience;		// 相关试验驾驶经验
	private String comName;		// 委外单位名称
	
	public TlDriverAblility() {
		super();
	}

	public TlDriverAblility(String id){
		super(id);
	}

	@Length(min=1, max=50, message="姓名长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=6, message="驾龄长度必须介于 1 和 6 之间")
	public String getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}
	
	@Length(min=1, max=1, message="性别长度必须介于 1 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=4, message="申请等级长度必须介于 1 和 4 之间")
	public String getApplyLevel() {
		return applyLevel;
	}

	public void setApplyLevel(String applyLevel) {
		this.applyLevel = applyLevel;
	}
	
	@Length(min=1, max=50, message="相关试验驾驶经验长度必须介于 1 和 50 之间")
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Length(min=1, max=4, message="委外单位名称长度必须介于 1 和 4 之间")
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	
}