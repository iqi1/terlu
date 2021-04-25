<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>GNSS数据管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlDynamicGetEq/">GNSS数据列表</a></li>
		<shiro:hasPermission name="modules:tlDynamicGetEq:edit"><li><a href="${ctx}/modules/tlDynamicGetEq/form">GNSS数据添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlDynamicGetEq" action="${ctx}/modules/tlDynamicGetEq/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>开始地点：</label>
				<form:input path="startPlace" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>结束地点：</label>
				<form:input path="endPlace" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>开始时间：</label>
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlDynamicGetEq.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlDynamicGetEq.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>开始地点</th>
				<th>结束地点</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>绑定车辆</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlDynamicGetEq:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlDynamicGetEq">
			<tr>
				<td><a href="${ctx}/modules/tlDynamicGetEq/form?id=${tlDynamicGetEq.id}">
					${tlDynamicGetEq.startPlace}
				</a></td>
				<td>
					${tlDynamicGetEq.endPlace}
				</td>
				<td>
					<fmt:formatDate value="${tlDynamicGetEq.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlDynamicGetEq.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDynamicGetEq.bindCar}
				</td>
				<td>
					<fmt:formatDate value="${tlDynamicGetEq.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDynamicGetEq.remarks}
				</td>
				<shiro:hasPermission name="modules:tlDynamicGetEq:edit"><td>
    				<a href="${ctx}/modules/tlDynamicGetEq/form?id=${tlDynamicGetEq.id}">修改</a>
					<a href="${ctx}/modules/tlDynamicGetEq/delete?id=${tlDynamicGetEq.id}" onclick="return confirmx('确认要删除该动态获取设备使用记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>