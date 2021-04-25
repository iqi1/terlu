/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 驾驶员身份证Entity
 * @author wangqi
 * @version 2020-06-03
 */
public class TlDriverCard extends DataEntity<TlDriverCard> {
	
	private static final long serialVersionUID = 1L;
	private String photo;		// 证件照片
	private String name;
	private String nation;
	private String address;
	private String IDcard;
	private String birth;
	private Integer sex;
	
	public TlDriverCard() {
		super();
	}

	public TlDriverCard(String id){
		super(id);
	}

	@Length(min=0, max=100, message="证件照片长度必须介于 0 和 100 之间")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}