/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 电子签名Entity
 * @author sunlifeng
 * @version 2020-01-06
 */
public class TlSeal extends DataEntity<TlSeal> {
	
	private static final long serialVersionUID = 1L;
	private String alias;		// 显示名称
	private String sealPassword;		// 签名的密码
	private User user;		// 用户id
	private byte[] image;		// 印章图片
	
	public TlSeal() {
		super();
	}

	public TlSeal(String id){
		super(id);
	}

	@Length(min=1, max=64, message="显示名称长度必须介于 1 和 64 之间")
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Length(min=0, max=64, message="签名的密码长度必须介于 0 和 64 之间")
	public String getSealPassword() {
		return sealPassword;
	}

	public void setSealPassword(String sealPassword) {
		this.sealPassword = sealPassword;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}