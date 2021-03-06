/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 合同添加Entity
 * @author wangqi
 * @version 2020-02-17
 */
public class TlContract extends DataEntity<TlContract> {
	
	private static final long serialVersionUID = 1L;
	private String applyType;		// 申请类型
	private String changeType;		// 变更类型
	private String changeReason;		// 变更原因
	private String applyId;		// 合同申请编号
	private String originalContractId;		// 原合同信息表主键
	private String contractCode;		// 合同编码
	private String contractName;		// 合同名称
	private String contractDesc;		// 合同描述
	private String version;		// 版本号
	private String contractType;		// 合同类型
	private String contractProperty;		// 合同属性
	private String contractNature;		// 合同性质
	private String totalAmount;		// 总金额
	private String projectType;		// 项目类型
	private String createdByUserid;		// 拟制人编号
	private String createdBy;		// 拟制人名称
	private String signDeptNum;		// 拟制人部门编号
	private String signDept;		// 拟制人部门
	private String signEmail;		// 拟制人部邮箱
	private String signMobile;		// 拟制人部电话
	private byte[] formalContract;		// 正式合同附件
	private String relatedContract;		// 关联合同
	private String companyName;		// 甲方所属主体
	private String companyCode;		// 甲方所属主体编码
	private String supplierName;		// 乙方公司名称
	private String supplierCode;		// 乙方所属主体编码
	private String countryTaxpayerNumber;		// 纳税人识别号（国税
	private String localTaxpayerNumber;		// 纳税人识别号（地税
	private String contractPersonName;		// 联系人姓名
	private String contractPersonPost;		// 联系人职位
	private String contractPersonEmail;		// 联系人邮箱
	private String contractPersonTel;		// 联系人电话
	private String registeredAddress;		// 注册地址
	private String bankCode;		// 银行行号
	private String bankAccountNum;		// 银行帐号
	private String openBank;		// 开户行信息
	private String paySettleMode;		// 结算模式
	private String paySettleRate;		// 结算频率
	private String paySettleMethod;		// 结算方式
	private Date acceptanceDate;		// 验收日
	private String statusHt;		// 合同状态
	private String isValid;		// 是否有效
	private String beginSupplierName;		// 开始 乙方公司名称
	private String endSupplierName;		// 结束 乙方公司名称
	
	private Integer status;		// 审批状态
	private String procInsId;	// 流程实例
	private String procName;
	private String comment;
//	private User userLeader;	//领队试验员
	
	public TlContract() {
		super();
	}

	public TlContract(String id){
		super(id);
	}

	@Length(min=1, max=1, message="申请类型长度必须介于 1 和 1 之间")
	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	@Length(min=1, max=1, message="变更类型长度必须介于 1 和 1 之间")
	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	
	@Length(min=1, max=32, message="变更原因长度必须介于 1 和 32 之间")
	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	
	@Length(min=1, max=64, message="合同申请编号长度必须介于 1 和 64 之间")
	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	
	@Length(min=1, max=64, message="原合同信息表主键长度必须介于 1 和 64 之间")
	public String getOriginalContractId() {
		return originalContractId;
	}

	public void setOriginalContractId(String originalContractId) {
		this.originalContractId = originalContractId;
	}
	
	@Length(min=1, max=50, message="合同编码长度必须介于 1 和 50 之间")
	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	
	@Length(min=1, max=200, message="合同名称长度必须介于 1 和 200 之间")
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	@Length(min=1, max=512, message="合同描述长度必须介于 1 和 512 之间")
	public String getContractDesc() {
		return contractDesc;
	}

	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=1, max=4, message="合同类型长度必须介于 1 和 4 之间")
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	@Length(min=1, max=4, message="合同属性长度必须介于 1 和 4 之间")
	public String getContractProperty() {
		return contractProperty;
	}

	public void setContractProperty(String contractProperty) {
		this.contractProperty = contractProperty;
	}
	
	@Length(min=1, max=1, message="合同性质长度必须介于 1 和 1 之间")
	public String getContractNature() {
		return contractNature;
	}

	public void setContractNature(String contractNature) {
		this.contractNature = contractNature;
	}
	
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Length(min=1, max=50, message="项目类型长度必须介于 1 和 50 之间")
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	@Length(min=1, max=50, message="拟制人编号长度必须介于 1 和 50 之间")
	public String getCreatedByUserid() {
		return createdByUserid;
	}

	public void setCreatedByUserid(String createdByUserid) {
		this.createdByUserid = createdByUserid;
	}
	
	@Length(min=1, max=50, message="拟制人名称长度必须介于 1 和 50 之间")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Length(min=1, max=50, message="拟制人部门编号长度必须介于 1 和 50 之间")
	public String getSignDeptNum() {
		return signDeptNum;
	}

	public void setSignDeptNum(String signDeptNum) {
		this.signDeptNum = signDeptNum;
	}
	
	@Length(min=1, max=50, message="拟制人部门长度必须介于 1 和 50 之间")
	public String getSignDept() {
		return signDept;
	}

	public void setSignDept(String signDept) {
		this.signDept = signDept;
	}
	
	@Length(min=1, max=50, message="拟制人部邮箱长度必须介于 1 和 50 之间")
	public String getSignEmail() {
		return signEmail;
	}

	public void setSignEmail(String signEmail) {
		this.signEmail = signEmail;
	}
	
	@Length(min=1, max=50, message="拟制人部电话长度必须介于 1 和 50 之间")
	public String getSignMobile() {
		return signMobile;
	}

	public void setSignMobile(String signMobile) {
		this.signMobile = signMobile;
	}
	
	public byte[] getFormalContract() {
		return formalContract;
	}

	public void setFormalContract(byte[] formalContract) {
		this.formalContract = formalContract;
	}

	@Length(min=1, max=50, message="关联合同长度必须介于 1 和 50 之间")
	public String getRelatedContract() {
		return relatedContract;
	}

	public void setRelatedContract(String relatedContract) {
		this.relatedContract = relatedContract;
	}
	
	@Length(min=1, max=100, message="甲方所属主体长度必须介于 1 和 100 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=1, max=50, message="甲方所属主体编码长度必须介于 1 和 50 之间")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Length(min=1, max=100, message="乙方公司名称长度必须介于 1 和 100 之间")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@Length(min=1, max=50, message="乙方所属主体编码长度必须介于 1 和 50 之间")
	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	
	@Length(min=1, max=50, message="纳税人识别号（国税长度必须介于 1 和 50 之间")
	public String getCountryTaxpayerNumber() {
		return countryTaxpayerNumber;
	}

	public void setCountryTaxpayerNumber(String countryTaxpayerNumber) {
		this.countryTaxpayerNumber = countryTaxpayerNumber;
	}
	
	@Length(min=1, max=50, message="纳税人识别号（地税长度必须介于 1 和 50 之间")
	public String getLocalTaxpayerNumber() {
		return localTaxpayerNumber;
	}

	public void setLocalTaxpayerNumber(String localTaxpayerNumber) {
		this.localTaxpayerNumber = localTaxpayerNumber;
	}
	
	@Length(min=1, max=50, message="联系人姓名长度必须介于 1 和 50 之间")
	public String getContractPersonName() {
		return contractPersonName;
	}

	public void setContractPersonName(String contractPersonName) {
		this.contractPersonName = contractPersonName;
	}
	
	@Length(min=1, max=100, message="联系人职位长度必须介于 1 和 100 之间")
	public String getContractPersonPost() {
		return contractPersonPost;
	}

	public void setContractPersonPost(String contractPersonPost) {
		this.contractPersonPost = contractPersonPost;
	}
	
	@Length(min=1, max=100, message="联系人邮箱长度必须介于 1 和 100 之间")
	public String getContractPersonEmail() {
		return contractPersonEmail;
	}

	public void setContractPersonEmail(String contractPersonEmail) {
		this.contractPersonEmail = contractPersonEmail;
	}
	
	@Length(min=1, max=100, message="联系人电话长度必须介于 1 和 100 之间")
	public String getContractPersonTel() {
		return contractPersonTel;
	}

	public void setContractPersonTel(String contractPersonTel) {
		this.contractPersonTel = contractPersonTel;
	}
	
	@Length(min=1, max=200, message="注册地址长度必须介于 1 和 200 之间")
	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	
	@Length(min=1, max=50, message="银行行号长度必须介于 1 和 50 之间")
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@Length(min=1, max=50, message="银行帐号长度必须介于 1 和 50 之间")
	public String getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}
	
	@Length(min=1, max=100, message="开户行信息长度必须介于 1 和 100 之间")
	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	
	@Length(min=1, max=4, message="结算模式长度必须介于 1 和 4 之间")
	public String getPaySettleMode() {
		return paySettleMode;
	}

	public void setPaySettleMode(String paySettleMode) {
		this.paySettleMode = paySettleMode;
	}
	
	@Length(min=1, max=4, message="结算频率长度必须介于 1 和 4 之间")
	public String getPaySettleRate() {
		return paySettleRate;
	}

	public void setPaySettleRate(String paySettleRate) {
		this.paySettleRate = paySettleRate;
	}
	
	@Length(min=1, max=4, message="结算方式长度必须介于 1 和 4 之间")
	public String getPaySettleMethod() {
		return paySettleMethod;
	}

	public void setPaySettleMethod(String paySettleMethod) {
		this.paySettleMethod = paySettleMethod;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="验收日不能为空")
	public Date getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	
	@Length(min=1, max=4, message="状态长度必须介于 1 和 4 之间")
	public String getStatusHt() {
		return statusHt;
	}

	public void setStatusHt(String statusHt) {
		this.statusHt = statusHt;
	}
	
	@Length(min=1, max=1, message="是否有效长度必须介于 1 和 1 之间")
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	public String getBeginSupplierName() {
		return beginSupplierName;
	}

	public void setBeginSupplierName(String beginSupplierName) {
		this.beginSupplierName = beginSupplierName;
	}
	
	public String getEndSupplierName() {
		return endSupplierName;
	}

	public void setEndSupplierName(String endSupplierName) {
		this.endSupplierName = endSupplierName;
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
		
	
}