<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划排班管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlWeekScheduleDetails/">计划排班列表</a></li>
		<shiro:hasPermission name="modules:tlWeekScheduleDetails:edit"><li><a href="${ctx}/modules/tlWeekScheduleDetails/form">计划排班添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlWeekScheduleDetails" action="${ctx}/modules/tlWeekScheduleDetails/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>计划周：</label>
				<form:select path="msid" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${weekList}" itemLabel="mid" itemValue="id" htmlEscape="false"/>
				</form:select>
			</li>
			<!--  <li><label>项目id：</label>
				<form:input path="projectId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>-->
			<li><label>测试道路：</label>
				<form:input path="testRoad" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>测试日期：</label>
				<input name="testDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlWeekScheduleDetails.testDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>测试时序：</label>
				<form:input path="timeSeries" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>关联主表mid</th>
				<th>项目id</th>
				<th>测试道路</th>
				<th>测试日期</th>
				<th>测试时序</th>
				<shiro:hasPermission name="modules:tlWeekScheduleDetails:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlWeekScheduleDetails">
			<tr>
				<td><a href="${ctx}/modules/tlWeekScheduleDetails/form?id=${tlWeekScheduleDetails.id}">
					${tlWeekScheduleDetails.weekName}
				</a></td>
				<td>
					${tlWeekScheduleDetails.projectId}
				</td>
				<td>
					${fns:getDictLabel(tlWeekScheduleDetails.testRoad, 'test_road', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlWeekScheduleDetails.testDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${tlWeekScheduleDetails.timeSeries}
				</td>
				<shiro:hasPermission name="modules:tlWeekScheduleDetails:edit"><td>
    				<a href="${ctx}/modules/tlWeekScheduleDetails/form?id=${tlWeekScheduleDetails.id}">修改</a>
					<a href="${ctx}/modules/tlWeekScheduleDetails/delete?id=${tlWeekScheduleDetails.id}" onclick="return confirmx('确认要删除该计划排班吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>