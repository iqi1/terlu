<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>周计划附表管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlWeekSchedule/">周计划附表列表</a></li>
		<shiro:hasPermission name="modules:tlWeekSchedule:edit"><li><a href="${ctx}/modules/tlWeekSchedule/form">周计划附表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlWeekSchedule" action="${ctx}/modules/tlWeekSchedule/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>测试时长：</label>
				<form:input path="testTime" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>车辆数：</label>
				<form:input path="carNum" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li><label>测试道路：</label>
				<form:select path="testRoad" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>周编号</th>
				<th>测试时长</th>
				<th>车辆数</th>
				<th>测试道路</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlWeekSchedule:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlWeekSchedule">
			<tr>
				<td><a href="${ctx}/modules/tlWeekSchedule/form?id=${tlWeekSchedule.id}">
					${tlWeekSchedule.mid}
				</a></td>
				<td>
					${tlWeekSchedule.testTime}
				</td>
				<td>
					${tlWeekSchedule.carNum}
				</td>
				<td>
					${fns:getDictLabel(tlWeekSchedule.testRoad, 'test_road', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlWeekSchedule.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlWeekSchedule.remarks}
				</td>
				<shiro:hasPermission name="modules:tlWeekSchedule:edit"><td>
    				<a href="${ctx}/modules/tlWeekSchedule/form?id=${tlWeekSchedule.id}">修改</a>
					<a href="${ctx}/modules/tlWeekSchedule/delete?id=${tlWeekSchedule.id}" onclick="return confirmx('确认要删除该周计划附表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>