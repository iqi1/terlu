<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>加油申请管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlFuelManage/">加油申请列表</a></li>
		<shiro:hasPermission name="modules:tlFuelManage:edit"><li><a href="${ctx}/modules/tlFuelManage/form">加油申请添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlFuelManage" action="${ctx}/modules/tlFuelManage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>燃料类型：</label>
				<form:select path="fuelType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fuel_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>项目名称</th>
				<th>测试道路</th>
				<th>接单人</th>
				<th>燃料类型</th>
				<th>加油量</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<!-- <th>状态</th> -->
				<shiro:hasPermission name="modules:tlFuelManage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlFuelManage">
			<tr>
				<td><a href="${ctx}/modules/tlFuelManage/form?id=${tlFuelManage.id}">
					${tlFuelManage.companyName}
				</a></td>
				<td>
					${fns:getDictLabel(tlFuelManage.testRoad, 'test_road', '')}
				</td>
				<td>
					${tlFuelManage.leadTester}
				</td>
				<td>
					${fns:getDictLabel(tlFuelManage.fuelType, 'fuel_type', '')}
				</td>
				<td>
					${tlFuelManage.consume}
				</td>
				<td>
					<fmt:formatDate value="${tlFuelManage.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlFuelManage.remarks}
				</td>
				<shiro:hasPermission name="modules:tlFuelManage:edit"><td>
    				<a href="${ctx}/modules/tlFuelManage/form?id=${tlFuelManage.id}">修改</a>
					<a href="${ctx}/modules/tlFuelManage/delete?id=${tlFuelManage.id}" onclick="return confirmx('确认要删除该加油申请吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>