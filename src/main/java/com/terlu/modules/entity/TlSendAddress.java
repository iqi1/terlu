/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 寄送信息登记Entity
 * @author wangqi
 * @version 2020-01-02
 */
public class TlSendAddress extends DataEntity<TlSendAddress> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private String sendAddress;		// 寄送地址
	private String zipCode;		// 邮编
	private String telSend;		// 寄送联系电话
	private String senderName;		// 寄件人姓名
	private String receiverName;		// 收件人姓名
	private String senderCompany;		// 寄件人公司
	private String receiverCompany;		// 收件人公司
	private String telSender;		// 寄件人电话
	private String telReceiver;		// 收件人电话
	private String assistantName;		// 试验场客户助理姓名
	
	public TlSendAddress() {
		super();
	}

	public TlSendAddress(String id){
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
	
	@Length(min=1, max=100, message="寄送地址长度必须介于 1 和 100 之间")
	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	
	@Length(min=0, max=6, message="邮编长度必须介于 0 和 6 之间")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Length(min=1, max=15, message="寄送联系电话长度必须介于 1 和 15 之间")
	public String getTelSend() {
		return telSend;
	}

	public void setTelSend(String telSend) {
		this.telSend = telSend;
	}
	
	@Length(min=1, max=64, message="寄件人姓名长度必须介于 1 和 64 之间")
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	@Length(min=1, max=64, message="收件人姓名长度必须介于 1 和 64 之间")
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	@Length(min=0, max=100, message="寄件人公司长度必须介于 0 和 100 之间")
	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}
	
	@Length(min=0, max=100, message="收件人公司长度必须介于 0 和 100 之间")
	public String getReceiverCompany() {
		return receiverCompany;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}
	
	@Length(min=1, max=15, message="寄件人电话长度必须介于 1 和 15 之间")
	public String getTelSender() {
		return telSender;
	}

	public void setTelSender(String telSender) {
		this.telSender = telSender;
	}
	
	@Length(min=1, max=15, message="收件人电话长度必须介于 1 和 15 之间")
	public String getTelReceiver() {
		return telReceiver;
	}

	public void setTelReceiver(String telReceiver) {
		this.telReceiver = telReceiver;
	}
	
	@Length(min=0, max=64, message="试验场客户助理姓名长度必须介于 0 和 64 之间")
	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	
}