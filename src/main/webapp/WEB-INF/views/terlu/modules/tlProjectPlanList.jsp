<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目计划管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlProjectPlan/">项目计划列表</a></li>
		<shiro:hasPermission name="modules:tlProjectPlan:edit"><li><a href="${ctx}/modules/tlProjectPlan/form">项目计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlProjectPlan" action="${ctx}/modules/tlProjectPlan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目名称：</label>
				<form:input path="projectName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目编号</th>
				<th>项目名称</th>
				<th>项目经理</th>
				<th>项目出资人</th>
				<th>项目审核人</th>
				<th>项目目标</th>
				<th>项目计划开始时间</th>
				<th>项目计划完成时间</th>
				<th>项目评价标准</th>
				<th>项目阶段性计划</th>
				<th>项目约束条件</th>
				<th>项目状态</th>
				<th>附件</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlProjectPlan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlProjectPlan">
			<tr>
				<td><a href="${ctx}/modules/tlProjectPlan/form?id=${tlProjectPlan.id}">
					${tlProjectPlan.projectCode}
				</a></td>
				<td>
					${tlProjectPlan.projectName}
				</td>
				<td>
					${tlProjectPlan.projectManager}
				</td>
				<td>
					${tlProjectPlan.projectPatron}
				</td>
				<td>
					${tlProjectPlan.projectApprove}
				</td>
				<td>
					${tlProjectPlan.projectTarget}
				</td>
				<td>
					<fmt:formatDate value="${tlProjectPlan.planBegindate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlProjectPlan.planEnddate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlProjectPlan.projectStandard}
				</td>
				<td>
					${tlProjectPlan.projectSchedule}
				</td>
				<td>
					${tlProjectPlan.projectRisk}
				</td>
				<td>
					${tlProjectPlan.projectStatus}
				</td>
				<td>
					${tlProjectPlan.attachment}
				</td>
				<td>
					<fmt:formatDate value="${tlProjectPlan.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlProjectPlan.remarks}
				</td>
				<shiro:hasPermission name="modules:tlProjectPlan:edit"><td>
    				<a href="${ctx}/modules/tlProjectPlan/form?id=${tlProjectPlan.id}">修改</a>
					<a href="${ctx}/modules/tlProjectPlan/delete?id=${tlProjectPlan.id}" onclick="return confirmx('确认要删除该项目计划吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>