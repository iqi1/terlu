<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同添加管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/modules/tlContract/">合同添加列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlContract/form?id=${tlContract.id}">合同添加<shiro:hasPermission name="modules:tlContract:edit">${not empty tlContract.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlContract:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlContract" action="${ctx}/modules/tlContract/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">申请类型：</label>
			<div class="controls">
				<form:select path="applyType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('apply_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">变更类型：</label>
			<div class="controls">
				<form:select path="changeType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('change_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<!-- <span class="help-inline"><font color="red">*</font> </span> -->
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">变更原因：</label>
			<div class="controls">
				<form:input path="changeReason" htmlEscape="false" maxlength="32" class="input-xlarge<%--  required --%>"/>
				<!-- <span class="help-inline"><font color="red">*</font> </span> -->
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同申请编号：</label>
			<div class="controls">
				<form:input path="applyId" htmlEscape="false" maxlength="32" class="input-xlarge<%--  required --%>"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
			<%-- <div class="controls">
				<form:input path="applyId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
					${tlContract.applyId}
					<form:options items="${fns:getDictList('change_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					
				<span class="help-inline"><font color="red">*</font> </span>
			</div> --%>
		</div>
		<div class="control-group">
			<label class="control-label">原合同信息表主键：</label>
			<div class="controls">
				<form:input path="originalContractId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同编码：</label>
			<div class="controls">
				<form:input path="contractCode" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同名称：</label>
			<div class="controls">
				<form:input path="contractName" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同描述：</label>
			<div class="controls">
				<form:input path="contractDesc" htmlEscape="false" maxlength="512" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">版本号：</label>
			<div class="controls">
				<form:input path="version" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同类型：</label>
			<div class="controls">
				<form:select path="contractType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('contract_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同属性：</label>
			<div class="controls">
				<form:select path="contractProperty" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('contract_property')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同性质：</label>
			<div class="controls">
				<form:select path="contractNature" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('contract_nature')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总金额：</label>
			<div class="controls">
				<form:input path="totalAmount" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目类型：</label>
			<div class="controls">
				<form:input path="projectType" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人编号：</label>
			<div class="controls">
				<form:input path="createdByUserid" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人名称：</label>
			<div class="controls">
				<form:input path="createdBy" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人部门编号：</label>
			<div class="controls">
				<form:input path="signDeptNum" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人部门：</label>
			<div class="controls">
				<form:input path="signDept" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人部邮箱：</label>
			<div class="controls">
				<form:input path="signEmail" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟制人部电话：</label>
			<div class="controls">
				<form:input path="signMobile" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">正式合同附件：</label>
			<div class="controls">
				<%-- <form:input path="formalContract" htmlEscape="false" maxlength="50" class="input-xlarge required"/> --%>
				<td><input id="fileupload" type="file" name="files"></td>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联合同：</label>
			<div class="controls">
				<form:input path="relatedContract" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">甲方所属主体：</label>
			<div class="controls">
				<form:input path="companyName" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">甲方所属主体编码：</label>
			<div class="controls">
				<form:input path="companyCode" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">乙方公司名称：</label>
			<div class="controls">
				<form:input path="supplierName" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">乙方所属主体编码：</label>
			<div class="controls">
				<form:input path="supplierCode" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纳税人识别号（国税：</label>
			<div class="controls">
				<form:input path="countryTaxpayerNumber" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纳税人识别号（地税：</label>
			<div class="controls">
				<form:input path="localTaxpayerNumber" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人姓名：</label>
			<div class="controls">
				<form:input path="contractPersonName" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人职位：</label>
			<div class="controls">
				<form:input path="contractPersonPost" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人邮箱：</label>
			<div class="controls">
				<form:input path="contractPersonEmail" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人电话：</label>
			<div class="controls">
				<form:input path="contractPersonTel" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册地址：</label>
			<div class="controls">
				<form:input path="registeredAddress" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">银行行号：</label>
			<div class="controls">
				<form:input path="bankCode" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">银行帐号：</label>
			<div class="controls">
				<form:input path="bankAccountNum" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户行信息：</label>
			<div class="controls">
				<form:input path="openBank" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结算模式：</label>
			<div class="controls">
				<form:select path="paySettleMode" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('pay_settle_mode')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结算频率：</label>
			<div class="controls">
				<form:select path="paySettleRate" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('pay_settle_rate')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结算方式：</label>
			<div class="controls">
				<form:select path="paySettleMethod" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('pay_settle_method')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">验收日：</label>
			<div class="controls">
				<input name="acceptanceDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${tlContract.acceptanceDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="status" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否有效：</label>
			<div class="controls">
				<form:select path="isValid" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('is_valid')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlContract:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>