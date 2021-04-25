<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>结算单主表管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlPaymentForm/">结算单主表列表</a></li>
		<shiro:hasPermission name="modules:tlPaymentForm:edit"><li><a href="${ctx}/modules/tlPaymentForm/form">结算单主表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlPaymentForm" action="${ctx}/modules/tlPaymentForm/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>付款单编码：</label>
				<form:input path="paidCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>公司名称：</label>
				<form:input path="companyName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>联系人：</label>
				<form:input path="contacts" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>付款类型：</label>
				<form:select path="paymentType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('payment_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>付款单编码</th>
				<th>公司代码</th>
				<th>公司名称</th>
				<th>联系人</th>
				<th>联系人电话</th>
				<th>付款申请时间</th>
				<th>应付款时间</th>
				<th>实际付款时间</th>
				<th>付款类型</th>
				<th>付款申请金额</th>
				<th>付款核准金额</th>
				<th>发票编号</th>
				<th>发票流水号</th>
				<th>付款类型</th>
				<th>作废原因</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlPaymentForm:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlPaymentForm">
			<tr>
				<td><a href="${ctx}/modules/tlPaymentForm/form?id=${tlPaymentForm.id}">
					${tlPaymentForm.paidCode}
				</a></td>
				<td>
					${tlPaymentForm.companyCode}
				</td>
				<td>
					${tlPaymentForm.companyName}
				</td>
				<td>
					${tlPaymentForm.contacts}
				</td>
				<td>
					${tlPaymentForm.contactsTel}
				</td>
				<td>
					<fmt:formatDate value="${tlPaymentForm.applicationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlPaymentForm.paymentPalnDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlPaymentForm.paymentActualDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(tlPaymentForm.paymentType, 'payment_type', '')}
				</td>
				<td>
					${tlPaymentForm.applicationPaymentAmount}
				</td>
				<td>
					${tlPaymentForm.confirmPaymentAmount}
				</td>
				<td>
					${tlPaymentForm.invoiceCode}
				</td>
				<td>
					${tlPaymentForm.invoiceNo}
				</td>
				<td>
					${fns:getDictLabel(tlPaymentForm.paymentStatus, 'payment_status', '')}
				</td>
				<td>
					${tlPaymentForm.reason}
				</td>
				<td>
					<fmt:formatDate value="${tlPaymentForm.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlPaymentForm.remarks}
				</td>
				<shiro:hasPermission name="modules:tlPaymentForm:edit"><td>
    				<a href="${ctx}/modules/tlPaymentForm/form?id=${tlPaymentForm.id}">修改</a>
					<a href="${ctx}/modules/tlPaymentForm/delete?id=${tlPaymentForm.id}" onclick="return confirmx('确认要删除该结算单主表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>