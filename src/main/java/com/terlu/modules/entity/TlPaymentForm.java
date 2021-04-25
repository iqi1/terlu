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
 * 结算单主表Entity
 * @author wangqi
 * @version 2020-02-25
 */
public class TlPaymentForm extends DataEntity<TlPaymentForm> {
	
	private static final long serialVersionUID = 1L;
	private String paidCode;		// 付款单编码
	private String companyCode;		// 公司代码
	private String companyName;		// 公司名称
	private String contacts;		// 联系人
	private String contactsTel;		// 联系人电话
	private Date applicationDate;		// 付款申请时间
	private Date paymentPalnDate;		// 应付款时间
	private Date paymentActualDate;		// 实际付款时间
	private String paymentType;		// 付款类型
	private String applicationPaymentAmount;		// 付款申请金额
	private String confirmPaymentAmount;		// 付款核准金额
	private String invoiceCode;		// 发票编号
	private String invoiceNo;		// 发票流水号
	private String paymentStatus;		// 付款类型
	private String reason;		// 作废原因
	
	public TlPaymentForm() {
		super();
	}

	public TlPaymentForm(String id){
		super(id);
	}

	@Length(min=1, max=64, message="付款单编码长度必须介于 1 和 64 之间")
	public String getPaidCode() {
		return paidCode;
	}

	public void setPaidCode(String paidCode) {
		this.paidCode = paidCode;
	}
	
	@Length(min=1, max=64, message="公司代码长度必须介于 1 和 64 之间")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Length(min=1, max=64, message="公司名称长度必须介于 1 和 64 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=1, max=64, message="联系人长度必须介于 1 和 64 之间")
	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	
	@Length(min=1, max=15, message="联系人电话长度必须介于 1 和 15 之间")
	public String getContactsTel() {
		return contactsTel;
	}

	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="付款申请时间不能为空")
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="应付款时间不能为空")
	public Date getPaymentPalnDate() {
		return paymentPalnDate;
	}

	public void setPaymentPalnDate(Date paymentPalnDate) {
		this.paymentPalnDate = paymentPalnDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="实际付款时间不能为空")
	public Date getPaymentActualDate() {
		return paymentActualDate;
	}

	public void setPaymentActualDate(Date paymentActualDate) {
		this.paymentActualDate = paymentActualDate;
	}
	
	@Length(min=1, max=4, message="付款类型长度必须介于 1 和 4 之间")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getApplicationPaymentAmount() {
		return applicationPaymentAmount;
	}

	public void setApplicationPaymentAmount(String applicationPaymentAmount) {
		this.applicationPaymentAmount = applicationPaymentAmount;
	}
	
	public String getConfirmPaymentAmount() {
		return confirmPaymentAmount;
	}

	public void setConfirmPaymentAmount(String confirmPaymentAmount) {
		this.confirmPaymentAmount = confirmPaymentAmount;
	}
	
	@Length(min=1, max=64, message="发票编号长度必须介于 1 和 64 之间")
	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	
	@Length(min=1, max=64, message="发票流水号长度必须介于 1 和 64 之间")
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	@Length(min=1, max=4, message="付款类型长度必须介于 1 和 4 之间")
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Length(min=1, max=64, message="作废原因长度必须介于 1 和 64 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}