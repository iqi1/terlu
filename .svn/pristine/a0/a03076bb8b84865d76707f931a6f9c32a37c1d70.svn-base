<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>卡记录管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlCardRecord/">卡记录列表</a></li>
		<shiro:hasPermission name="modules:tlCardRecord:edit"><li><a href="${ctx}/modules/tlCardRecord/form">卡记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlCardRecord" action="${ctx}/modules/tlCardRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>驾驶员id：</label>
				<form:input path="driverName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> --%>
			<li><label>卡号：</label>
				<form:input path="cardNum" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li>
			<li><label>已领/未领：</label>
				<form:select path="state" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>驾驶员id</th>
				<th>卡号</th>
				<th>已领/未领</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlCardRecord:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlCardRecord">
			<tr>
				<td><a href="${ctx}/modules/tlCardRecord/form?id=${tlCardRecord.id}">
					${tlCardRecord.driverName}
				</a></td>
				<td>
					${tlCardRecord.cardNum}
				</td>
				<td>
					${fns:getDictLabel(tlCardRecord.state, 'state', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlCardRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlCardRecord.remarks}
				</td>
				<shiro:hasPermission name="modules:tlCardRecord:edit"><td>
    				<a href="${ctx}/modules/tlCardRecord/form?id=${tlCardRecord.id}">修改</a>
					<a href="${ctx}/modules/tlCardRecord/delete?id=${tlCardRecord.id}" onclick="return confirmx('确认要删除该卡记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>