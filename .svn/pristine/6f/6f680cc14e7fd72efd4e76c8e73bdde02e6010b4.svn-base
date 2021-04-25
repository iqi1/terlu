<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>油/电卡管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlFuelchargeCard/">油/电卡列表</a></li>
		<shiro:hasPermission name="modules:tlFuelchargeCard:edit"><li><a href="${ctx}/modules/tlFuelchargeCard/form">油/电卡添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlFuelchargeCard" action="${ctx}/modules/tlFuelchargeCard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>卡号：</label>
				<form:input path="cardNum" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>数量(L/KWH)：</label>
				<form:input path="quantity" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>卡号</th>
				<th>数量</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlFuelchargeCard:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlFuelchargeCard">
			<tr>
				<td><a href="${ctx}/modules/tlFuelchargeCard/form?id=${tlFuelchargeCard.id}">
					${tlFuelchargeCard.cardNum}
				</a></td>
				<td>
					${tlFuelchargeCard.quantity}
				</td>
				<td>
					<fmt:formatDate value="${tlFuelchargeCard.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlFuelchargeCard.remarks}
				</td>
				<shiro:hasPermission name="modules:tlFuelchargeCard:edit"><td>
    				<a href="${ctx}/modules/tlFuelchargeCard/form?id=${tlFuelchargeCard.id}">修改</a>
					<a href="${ctx}/modules/tlFuelchargeCard/delete?id=${tlFuelchargeCard.id}" onclick="return confirmx('确认要删除该油/电卡吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>