/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 驾驶员证件Entity
 * @author wangqi
 * @version 2020-06-02
 */
public class TlDriverZj extends DataEntity<TlDriverZj> {
	
	private static final long serialVersionUID = 1L;
	private String tel;		//电话
	private byte[] idcardPhoto;	//身份证照片
	private byte[] licensePhoto;	//证件照片
	private String name;	//姓名
	private String nation;
	private String address;
	private String IDcard;
	private String birth;
	private String sex;
	private Integer status;		// 审批状态
	private String procInsId;	// 流程实例
	private String procName;
	private String comment;
	private User userLeader;	//领队试验员
	
	public TlDriverZj() {
		super();
	}

	public TlDriverZj(String id){
		super(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public byte[] getIdcardPhoto() {
		return idcardPhoto;
	}

	public void setIdcardPhoto(byte[] idcardPhoto) {
		this.idcardPhoto = idcardPhoto;
	}

	public byte[] getLicensePhoto() {
		return licensePhoto;
	}

	public void setLicensePhoto(byte[] licensePhoto) {
		this.licensePhoto = licensePhoto;
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

	public User getUserLeader() {
		return userLeader;
	}

	public void setUserLeader(User userLeader) {
		this.userLeader = userLeader;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}