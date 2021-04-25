<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同添加管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/modules/tlContract/">合同添加列表</a></li>
		<shiro:hasPermission name="modules:tlContract:edit"><li><a href="${ctx}/modules/tlContract/form">合同添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="tlContract" action="${ctx}/modules/tlContract/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>申请类型：</label>
				<form:select path="applyType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('apply_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>合同申请编号：</label>
				<form:input path="applyId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>合同编码：</label>
				<form:input path="contractCode" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>关联合同：</label>
				<form:input path="relatedContract" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>乙方公司名称：</label>
				<form:input path="supplierName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form> --%>
	<!-- ************************************************************************************** -->
	<div id="tabs-0"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-0" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<tbody>
						<tr>
							<td colspan="7" rowspan="2" 
								style="width: 242px; height: 10px; font-size: 10ps">申请类型</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 10px; font-size: 10ps">${tlContract.applyType}</td>
							<td colspan="4" 
								style="width: 138px; height: 10px; font-size: 10ps">变更类型</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.changeType}</td>
						 </tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 10px; font-size: 10ps">变更原因</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 10px; font-size: 10ps">${tlContract.changeReason}</td>
							 <td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">合同申请编号</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.applyId}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2" 
								style="width: 242px; height: 20px; font-size: 10ps">原合同信息表主键</td>
							<td colspan="6" rowspan="2" 
								style="width: 207px; height: 20px; font-size: 10ps">${tlContract.originalContractId}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">合同编码</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">
								${tlContract.contractCode}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">合同名称</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.contractName}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">合同描述</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.contractDesc}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">版本号</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.version}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">合同类型</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${fns:getDictLabel(tlContract.contractType, 'contract_type', '')}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">合同属性</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${fns:getDictLabel(tlContract.contractProperty, 'contract_property', '')}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">合同性质</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${fns:getDictLabel(tlContract.contractNature, 'contract_nature', '')}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">总金额</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.totalAmount}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">项目类型</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.projectType}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">拟制人编号</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.createdByUserid}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">拟制人名称</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.createdBy}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">拟制人部门编号</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.signDeptNum}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">拟制人部门</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.signDept}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">拟制人邮箱</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.signEmail}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">拟制人电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.signMobile}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">甲方公司名称</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.companyName}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">甲方所属主体编码</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.companyCode}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">乙方公司名称</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.supplierName}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">乙方所属主体编码</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.supplierCode}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">纳税人识别号（国税）</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.countryTaxpayerNumber}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">纳税人识别号（地税）</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.localTaxpayerNumber}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">联系人姓名</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.contractPersonName}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">联系人职位</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.contractPersonPost}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">联系人邮箱</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.contractPersonEmail}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">联系人电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.contractPersonTel}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">注册地址</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.registeredAddress}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">银行行号</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.bankCode}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">银行账号</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.bankAccountNum}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">开户行信息</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.openBank}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">结算模式</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.paySettleMode}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">计算频率</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.paySettleRate}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">结算方式</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.paySettleMethod}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">验收日</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.acceptanceDate}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">状态</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.status}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">是否有效</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.isValid}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">更新时间</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.updateDate}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">备注信息</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.remarks}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">关联合同</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlContract.relatedContract}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">正式合同附件</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.formalContract}</td>
						</tr>
						<%-- <tr>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">拟制人编号</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlContract.emailC}</td>
						</tr> --%>
					</tbody>
				</table>
			</div>
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	<sys:message content="${message}"/>
	<div class="pagination">${page}</div>
</body>
</html>