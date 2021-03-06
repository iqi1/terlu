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
		<shiro:hasPermission name="modules:tlContract:edit"><li><a href="${ctx}/modules/tlContract/form">合同添加添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlContract" action="${ctx}/modules/tlContract/" method="post" class="breadcrumb form-search">
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
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>编号</th> -->
				<th>申请类型</th>
				<!-- <th>变更类型</th>
				<th>变更原因</th> -->
				<th>合同申请编号</th>
				<th>原合同信息表主键</th>
				<th>合同编码</th>
				<th>合同名称</th>
				<th>合同描述</th>
				<th>版本号</th>
				<th>合同类型</th>
				<th>合同属性</th>
				<th>合同性质</th>
				<!-- <th>总金额</th>
				<th>项目类型</th>
				<th>拟制人编号</th>
				<th>拟制人名称</th>
				<th>拟制人部门编号</th>
				<th>拟制人部门</th>
				<th>拟制人部邮箱</th>
				<th>拟制人部电话</th>
				<th>正式合同附件</th>
				<th>关联合同</th>
				<th>甲方所属主体</th>
				<th>甲方所属主体编码</th>
				<th>乙方公司名称</th>
				<th>乙方所属主体编码</th>
				<th>纳税人识别号（国税</th>
				<th>纳税人识别号（地税</th>
				<th>联系人姓名</th>
				<th>联系人职位</th>
				<th>联系人邮箱</th>
				<th>联系人电话</th>
				<th>注册地址</th>
				<th>银行行号</th>
				<th>银行帐号</th>
				<th>开户行信息</th>
				<th>结算模式</th>
				<th>结算频率</th>
				<th>结算方式</th>
				<th>验收日</th> -->
				<th>状态</th>
				<th>是否有效</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlContract:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlContract">
			<tr>
				<%-- <td><a href="${ctx}/modules/tlContract/form?id=${tlContract.id}">
					${tlContract.id}
				</a></td> --%>
				<td>
					${fns:getDictLabel(tlContract.applyType, 'apply_type', '')}
				</td>
				<%-- <td>
					${fns:getDictLabel(tlContract.changeType, 'change_type', '')}
				</td>
				<td>
					${tlContract.changeReason}
				</td> --%>
				<td>
					${tlContract.applyId}
				</td>
				<td>
					${tlContract.originalContractId}
				</td>
				<td>
					${tlContract.contractCode}
				</td>
				<td>
					${tlContract.contractName}
				</td>
				<td>
					${tlContract.contractDesc}
				</td>
				<td>
					${tlContract.version}
				</td>
				<td>
					${fns:getDictLabel(tlContract.contractType, 'contract_type', '')}
				</td>
				<td>
					${fns:getDictLabel(tlContract.contractProperty, 'contract_property', '')}
				</td>
				<td>
					${fns:getDictLabel(tlContract.contractNature, 'contract_nature', '')}
				</td>
				<%-- <td>
					${tlContract.totalAmount}
				</td>
				<td>
					${tlContract.projectType}
				</td>
				<td>
					${tlContract.createdByUserid}
				</td>
				<td>
					${tlContract.createdBy}
				</td>
				<td>
					${tlContract.signDeptNum}
				</td>
				<td>
					${tlContract.signDept}
				</td>
				<td>
					${tlContract.signEmail}
				</td>
				<td>
					${tlContract.signMobile}
				</td>
				<td>
					${tlContract.formalContract}
				</td>
				<td>
					${tlContract.relatedContract}
				</td>
				<td>
					${tlContract.companyName}
				</td>
				<td>
					${tlContract.companyCode}
				</td>
				<td>
					${tlContract.supplierName}
				</td>
				<td>
					${tlContract.supplierCode}
				</td>
				<td>
					${tlContract.countryTaxpayerNumber}
				</td>
				<td>
					${tlContract.localTaxpayerNumber}
				</td>
				<td>
					${tlContract.contractPersonName}
				</td>
				<td>
					${tlContract.contractPersonPost}
				</td>
				<td>
					${tlContract.contractPersonEmail}
				</td>
				<td>
					${tlContract.contractPersonTel}
				</td>
				<td>
					${tlContract.registeredAddress}
				</td>
				<td>
					${tlContract.bankCode}
				</td>
				<td>
					${tlContract.bankAccountNum}
				</td>
				<td>
					${tlContract.openBank}
				</td>
				<td>
					${fns:getDictLabel(tlContract.paySettleMode, 'pay_settle_mode', '')}
				</td>
				<td>
					${fns:getDictLabel(tlContract.paySettleRate, 'pay_settle_rate', '')}
				</td>
				<td>
					${fns:getDictLabel(tlContract.paySettleMethod, 'pay_settle_method', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlContract.acceptanceDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${fns:getDictLabel(tlContract.status, 'status', '')}
				</td>
				<td>
					${fns:getDictLabel(tlContract.isValid, 'is_valid', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlContract.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlContract.remarks}
				</td>
				<shiro:hasPermission name="modules:tlContract:audit"><td>
					<a href="${ctx}/modules/tlContract/formAudit?id=${tlContract.id}&status=${tlContract.status}">提交审核</a>
				</td></shiro:hasPermission>
				<shiro:hasPermission name="modules:tlContract:edit"><td>
					<a href="${ctx}/modules/tlContract/formView?id=${tlContract.id}">详情</a>
				</td></shiro:hasPermission>
				<shiro:hasPermission name="modules:tlContract:edit"><td>
					<%-- <a href="${ctx}/modules/tlContract/formAudit?id=${tlContract.id}">详情</a> --%>
    				<a href="${ctx}/modules/tlContract/form?id=${tlContract.id}">修改</a>
					<a href="${ctx}/modules/tlContract/delete?id=${tlContract.id}" onclick="return confirmx('确认要删除该合同添加吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>