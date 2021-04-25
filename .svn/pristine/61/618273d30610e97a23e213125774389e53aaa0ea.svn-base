<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试车俩 计划管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlTestCarPlan/">测试车辆计划列表</a></li>
		<shiro:hasPermission name="modules:tlTestCarPlan:edit"><li><a href="${ctx}/modules/tlTestCarPlan/form">测试车辆计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlTestCarPlan" action="${ctx}/modules/tlTestCarPlan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>测试道路：</label>
				<form:select path="testRoad" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>开始时间：</label>
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlTestCarPlan.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlTestCarPlan.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>测试数量：</label>
				<form:input path="carCount" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>测试道路</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>同时测试数量</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlTestCarPlan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlTestCarPlan">
			<tr>
				<td><a href="${ctx}/modules/tlTestCarPlan/form?id=${tlTestCarPlan.id}">
					${fns:getDictLabel(tlTestCarPlan.testRoad, 'test_road', '')}
				</a></td>
				<td>
					<fmt:formatDate value="${tlTestCarPlan.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlTestCarPlan.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestCarPlan.carCount}
				</td>
				<td>
					<fmt:formatDate value="${tlTestCarPlan.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestCarPlan.remarks}
				</td>
				<shiro:hasPermission name="modules:tlTestCarPlan:edit"><td>
    				<a href="${ctx}/modules/tlTestCarPlan/form?id=${tlTestCarPlan.id}">修改</a>
					<a href="${ctx}/modules/tlTestCarPlan/delete?id=${tlTestCarPlan.id}" onclick="return confirmx('确认要删除该测试车俩 计划吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>