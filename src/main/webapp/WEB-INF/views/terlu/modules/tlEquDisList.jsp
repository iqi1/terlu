<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>设备分配表管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlEquDis/">设备分配表列表</a></li>
		<shiro:hasPermission name="modules:tlEquDis:edit"><li><a href="${ctx}/modules/tlEquDis/form">设备分配表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlEquDis" action="${ctx}/modules/tlEquDis/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备编号：</label>
				<form:input path="eid" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlEquDis:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlEquDis">
			<tr>
				<td><a href="${ctx}/modules/tlEquDis/form?id=${tlEquDis.id}">
					${tlEquDis.eid}
				</a></td>
				<td>
					<fmt:formatDate value="${tlEquDis.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlEquDis.remarks}
				</td>
				<shiro:hasPermission name="modules:tlEquDis:edit"><td>
    				<a href="${ctx}/modules/tlEquDis/form?id=${tlEquDis.id}">修改</a>
					<a href="${ctx}/modules/tlEquDis/delete?id=${tlEquDis.id}" onclick="return confirmx('确认要删除该设备分配表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>