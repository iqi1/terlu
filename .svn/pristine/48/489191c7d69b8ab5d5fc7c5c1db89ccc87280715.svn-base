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
 * 结算统计Entity
 * @author wangqi
 * @version 2020-02-20
 */
public class TlSettleAccounts extends DataEntity<TlSettleAccounts> {
	
	private static final long serialVersionUID = 1L;
	private String project;		// 项目
	private String company;		// 付款单位
	private String settleNum;		// 结算单号
	private String consignee;		// 确认人
	private Date deliveryTime;		// 确认时间
	private String totalAmount;		// 费用合计
	private String deductMoney;		// 扣款合计
	private String confirmAmount;		// 确认金额
	private byte[] attachment;		// 附件
	
	public TlSettleAccounts() {
		super();
	}

	public TlSettleAccounts(String id){
		super(id);
	}

	@Length(min=1, max=64, message="项目长度必须介于 1 和 64 之间")
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	@Length(min=1, max=64, message="付款单位长度必须介于 1 和 64 之间")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Length(min=1, max=64, message="结算单号长度必须介于 1 和 64 之间")
	public String getSettleNum() {
		return settleNum;
	}

	public void setSettleNum(String settleNum) {
		this.settleNum = settleNum;
	}
	
	@Length(min=1, max=64, message="确认人长度必须介于 1 和 64 之间")
	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="确认时间不能为空")
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getDeductMoney() {
		return deductMoney;
	}

	public void setDeductMoney(String deductMoney) {
		this.deductMoney = deductMoney;
	}
	
	public String getConfirmAmount() {
		return confirmAmount;
	}

	public void setConfirmAmount(String confirmAmount) {
		this.confirmAmount = confirmAmount;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
}