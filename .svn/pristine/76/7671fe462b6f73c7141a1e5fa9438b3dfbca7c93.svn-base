<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验任务单管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlTestTaskList/">试验任务单列表</a></li>
		<c:if test="${empty page.list}"> 
		<shiro:hasPermission name="modules:tlTestTaskList:edit"><li><a href="${ctx}/modules/tlTestTaskList/form?projectId=${tlTestTaskList.projectId}">试验任务单添加</a></li></shiro:hasPermission>
 		</c:if>
		
	</ul>
	<form:form id="searchForm" modelAttribute="tlTestTaskList" action="${ctx}/modules/tlTestTaskList/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>

	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目名称</th>
				<th>测试道路</th>
				<th>测试包场</th>
				<th>驾驶员</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlTestTaskList:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlTestTaskList">
			<tr>
				<td>
					${tlTestTaskList.companyName}
				</td>	
				<td>
					${fns:getDictLabel(tlTestTaskList.testRoad, 'test_road', '')}
				</td>
				<td>
					${fns:getDictLabel(tlTestTaskList.isBaoChang, 'yes_no', '')}
				</td>
				<td>
					${tlTestTaskList.driverName}
				</td>
				<td>
					<fmt:formatDate value="${tlTestTaskList.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlTestTaskList.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlTestTaskList.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestTaskList.remarks}
				</td>
				<c:if test="${tlTestTaskList.isModify == 1}"> 
				<shiro:hasPermission name="modules:tlTestTaskList:edit"><td>
    				<a href="${ctx}/modules/tlTestTaskList/form?id=${tlTestTaskList.id}">修改</a>
					<a href="${ctx}/modules/tlTestTaskList/delete?id=${tlTestTaskList.id}" onclick="return confirmx('确认要删除该试验任务单吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>