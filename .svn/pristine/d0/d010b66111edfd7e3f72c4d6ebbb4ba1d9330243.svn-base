<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试道路请求管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlRequestTestRoad/">测试道路请求列表</a></li>
		<shiro:hasPermission name="modules:tlRequestTestRoad:edit"><li><a href="${ctx}/modules/tlRequestTestRoad/form">测试道路请求添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlRequestTestRoad" action="${ctx}/modules/tlRequestTestRoad/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目</label>
				<form:select path="projectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${list}" itemLabel="companyName" itemValue="id" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>测试道路：</label>
				<form:select path="testRoad" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>开始时间：</label>
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlRequestTestRoad.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>项目</th>
				<th>测试道路</th>
				<th>测试数量</th>
				<th>测试日期</th>
<!--  				<th>结束时间</th>
				<th>更新时间</th>
				<th>备注信息</th>-->
				<shiro:hasPermission name="modules:tlRequestTestRoad:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlRequestTestRoad">
			<tr>
				<td><a href="${ctx}/modules/tlRequestTestRoad/form?projectId=${tlRequestTestRoad.projectId}&startTime=
				<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&testRoad=${tlRequestTestRoad.testRoad}">
					${tlRequestTestRoad.projectName}
				</a></td>
				<td>
					${fns:getDictLabel(tlRequestTestRoad.testRoad, 'test_road', '')}
				</td>
				<td>
					${tlRequestTestRoad.carCount}
				</td>
				<td>
					<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd"/>
				</td>
<!--				<td>
					<fmt:formatDate value="${tlRequestTestRoad.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlRequestTestRoad.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlRequestTestRoad.remarks}
				</td>-->
				<shiro:hasPermission name="modules:tlRequestTestRoad:edit"><td>
    				<a href="${ctx}/modules/tlRequestTestRoad/form?projectId=${tlRequestTestRoad.projectId}&startTime=
    				<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&testRoad=${tlRequestTestRoad.testRoad}">修改</a>
					<a href="${ctx}/modules/tlRequestTestRoad/delete?id=${tlRequestTestRoad.id}" onclick="return confirmx('确认要删除该测试道路请求吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>