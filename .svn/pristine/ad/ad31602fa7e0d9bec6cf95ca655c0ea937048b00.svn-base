<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>结算统计管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlSettleAccounts/">结算统计列表</a></li>
		<shiro:hasPermission name="modules:tlSettleAccounts:edit"><li><a href="${ctx}/modules/tlSettleAccounts/form">结算统计添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlSettleAccounts" action="${ctx}/modules/tlSettleAccounts/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目：</label>
				<form:input path="project" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>付款单位：</label>
				<form:input path="company" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>确认人：</label>
				<form:input path="consignee" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目</th>
				<th>付款单位</th>
				<th>结算单号</th>
				<th>确认人</th>
				<th>确认时间</th>
				<th>费用合计</th>
				<th>扣款合计</th>
				<th>确认金额</th>
				<th>附件</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlSettleAccounts:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlSettleAccounts">
			<tr>
				<td><a href="${ctx}/modules/tlSettleAccounts/form?id=${tlSettleAccounts.id}">
					${tlSettleAccounts.project}
				</a></td>
				<td>
					${tlSettleAccounts.company}
				</td>
				<td>
					${tlSettleAccounts.settleNum}
				</td>
				<td>
					${tlSettleAccounts.consignee}
				</td>
				<td>
					<fmt:formatDate value="${tlSettleAccounts.deliveryTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlSettleAccounts.totalAmount}
				</td>
				<td>
					${tlSettleAccounts.deductMoney}
				</td>
				<td>
					${tlSettleAccounts.confirmAmount}
				</td>
				<td>
					${tlSettleAccounts.attachment}
				</td>
				<td>
					<fmt:formatDate value="${tlSettleAccounts.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlSettleAccounts.remarks}
				</td>
				<shiro:hasPermission name="modules:tlSettleAccounts:edit"><td>
    				<a href="${ctx}/modules/tlSettleAccounts/form?id=${tlSettleAccounts.id}">修改</a>
					<a href="${ctx}/modules/tlSettleAccounts/delete?id=${tlSettleAccounts.id}" onclick="return confirmx('确认要删除该结算统计吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>