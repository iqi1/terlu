/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 财务信息登记Entity
 * @author wangqi
 * @version 2020-01-02
 */
public class TlFinanceInfo extends DataEntity<TlFinanceInfo> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private String invoiceRise;		// 发票抬头
	private String vatNumber;		// 增值税号
	private String invoiceReceiver;		// 发票接收人
	private String telInvRecever;		// 发票接收人联系电话
	private String email;		// 邮箱
	private String bankName;		// 开户银行名称
	private String accountBank;		// 开户行账号
	private String registeredAddress;		// 公司注册地址
	private String invoiceReceiveAddress;		// 发票接收地址
	
	public TlFinanceInfo() {
		super();
	}

	public TlFinanceInfo(String id){
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
	
	@Length(min=1, max=64, message="发票抬头长度必须介于 1 和 64 之间")
	public String getInvoiceRise() {
		return invoiceRise;
	}

	public void setInvoiceRise(String invoiceRise) {
		this.invoiceRise = invoiceRise;
	}
	
	@Length(min=1, max=20, message="增值税号长度必须介于 1 和 20 之间")
	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	
	@Length(min=1, max=64, message="发票接收人长度必须介于 1 和 64 之间")
	public String getInvoiceReceiver() {
		return invoiceReceiver;
	}

	public void setInvoiceReceiver(String invoiceReceiver) {
		this.invoiceReceiver = invoiceReceiver;
	}
	
	@Length(min=1, max=11, message="发票接收人联系电话长度必须介于 1 和 11 之间")
	public String getTelInvRecever() {
		return telInvRecever;
	}

	public void setTelInvRecever(String telInvRecever) {
		this.telInvRecever = telInvRecever;
	}
	
	@Length(min=1, max=64, message="邮箱长度必须介于 1 和 64 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=1, max=100, message="开户银行名称长度必须介于 1 和 100 之间")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Length(min=1, max=20, message="开户行账号长度必须介于 1 和 20 之间")
	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	
	@Length(min=1, max=100, message="公司注册地址长度必须介于 1 和 100 之间")
	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	
	@Length(min=1, max=100, message="发票接收地址长度必须介于 1 和 100 之间")
	public String getInvoiceReceiveAddress() {
		return invoiceReceiveAddress;
	}

	public void setInvoiceReceiveAddress(String invoiceReceiveAddress) {
		this.invoiceReceiveAddress = invoiceReceiveAddress;
	}
	
}