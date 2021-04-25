<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>GNSS设备管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlStaticWriteEq/">GNSS设备信息列表</a></li>
		<shiro:hasPermission name="modules:tlStaticWriteEq:edit"><li><a href="${ctx}/modules/tlStaticWriteEq/form">GNSS设备信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlStaticWriteEq" action="${ctx}/modules/tlStaticWriteEq/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备编号：</label>
				<form:input path="eqNum" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>SIM卡号：</label>
				<form:input path="simNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>SIM卡缴费记录：</label>
				<form:input path="simPayRecord" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>设备编号</th>
				<th>SIM卡号</th>
				<th>SIM卡缴费记录</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlStaticWriteEq:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlStaticWriteEq">
			<tr>
				<td><a href="${ctx}/modules/tlStaticWriteEq/form?id=${tlStaticWriteEq.id}">
					${tlStaticWriteEq.eqNum}
				</a></td>
				<td>
					${tlStaticWriteEq.simNum}
				</td>
				<td>
					${tlStaticWriteEq.simPayRecord}
				</td>
				<td>
					<fmt:formatDate value="${tlStaticWriteEq.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlStaticWriteEq.remarks}
				</td>
				<shiro:hasPermission name="modules:tlStaticWriteEq:edit"><td>
    				<a href="${ctx}/modules/tlStaticWriteEq/form?id=${tlStaticWriteEq.id}">修改</a>
					<a href="${ctx}/modules/tlStaticWriteEq/delete?id=${tlStaticWriteEq.id}" onclick="return confirmx('确认要删除该静态录入设备信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>