/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 其他信息Entity
 * @author wangqi
 * @version 2020-01-03
 */
public class TlOtherExtendsInfo extends DataEntity<TlOtherExtendsInfo> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private String isdanger;		// 是否包含高危险性试验？
	private String iscamera;		// 是否需要在场地内摄像或摄影
	private String dangerDescription;		// 危险性描述
	private String safeExplain;		// 安全措施说明
	private String publicWorkshop;		// 公共车间
	private String confidentialWorkshop;		// 保密车间
	private String meetingRoom;		// 会议室
	private String specificRequirement;		// 具体要求
	private String isCarRentalService;		// 是否需要租车服务
	private String isNeedHireTestDriver;		// 是否需要租用试验驾驶员
	private String otherSpecialServices;		// 其他特殊服务
	
	public TlOtherExtendsInfo() {
		super();
	}

	public TlOtherExtendsInfo(String id){
		super(id);
	}

	
	
	
	@Length(min=1, max=1, message="是否包含高危险性试验？长度必须介于 1 和 1 之间")
	public String getIsdanger() {
		return isdanger;
	}
	@JsonBackReference
	@NotNull(message="父id不能为空")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setIsdanger(String isdanger) {
		this.isdanger = isdanger;
	}
	
	@Length(min=1, max=1, message="是否需要在场地内摄像或摄影长度必须介于 1 和 1 之间")
	public String getIscamera() {
		return iscamera;
	}

	public void setIscamera(String iscamera) {
		this.iscamera = iscamera;
	}
	
	@Length(min=1, max=200, message="危险性描述长度必须介于 1 和 200 之间")
	public String getDangerDescription() {
		return dangerDescription;
	}

	public void setDangerDescription(String dangerDescription) {
		this.dangerDescription = dangerDescription;
	}
	
	@Length(min=0, max=200, message="安全措施说明长度必须介于 0 和 200 之间")
	public String getSafeExplain() {
		return safeExplain;
	}

	public void setSafeExplain(String safeExplain) {
		this.safeExplain = safeExplain;
	}
	
	@Length(min=0, max=1, message="公共车间长度必须介于 0 和 1 之间")
	public String getPublicWorkshop() {
		return publicWorkshop;
	}

	public void setPublicWorkshop(String publicWorkshop) {
		this.publicWorkshop = publicWorkshop;
	}
	
	@Length(min=0, max=1, message="保密车间长度必须介于 0 和 1 之间")
	public String getConfidentialWorkshop() {
		return confidentialWorkshop;
	}

	public void setConfidentialWorkshop(String confidentialWorkshop) {
		this.confidentialWorkshop = confidentialWorkshop;
	}
	
	@Length(min=0, max=1, message="会议室长度必须介于 0 和 1 之间")
	public String getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	
	@Length(min=0, max=64, message="具体要求长度必须介于 0 和 64 之间")
	public String getSpecificRequirement() {
		return specificRequirement;
	}

	public void setSpecificRequirement(String specificRequirement) {
		this.specificRequirement = specificRequirement;
	}
	
	@Length(min=1, max=1, message="是否需要租车服务长度必须介于 1 和 1 之间")
	public String getIsCarRentalService() {
		return isCarRentalService;
	}

	public void setIsCarRentalService(String isCarRentalService) {
		this.isCarRentalService = isCarRentalService;
	}
	
	@Length(min=1, max=1, message="是否需要租用试验驾驶员长度必须介于 1 和 1 之间")
	public String getIsNeedHireTestDriver() {
		return isNeedHireTestDriver;
	}

	public void setIsNeedHireTestDriver(String isNeedHireTestDriver) {
		this.isNeedHireTestDriver = isNeedHireTestDriver;
	}
	
	@Length(min=0, max=64, message="其他特殊服务长度必须介于 0 和 64 之间")
	public String getOtherSpecialServices() {
		return otherSpecialServices;
	}

	public void setOtherSpecialServices(String otherSpecialServices) {
		this.otherSpecialServices = otherSpecialServices;
	}
	
}