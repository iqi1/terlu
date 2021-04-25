<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>违规记录管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlViolationRecord/">违规记录列表</a></li>
		<shiro:hasPermission name="modules:tlViolationRecord:edit"><li><a href="${ctx}/modules/tlViolationRecord/form">违规记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlViolationRecord" action="${ctx}/modules/tlViolationRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>驾驶员姓名：</label>
				<form:input path="driverName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>驾驶员姓名</th>
				<th>联系电话</th>
				<th>违规记录</th>
				<th>违规时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlViolationRecord:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlViolationRecord">
			<tr>
				<td><a href="${ctx}/modules/tlViolationRecord/form?id=${tlViolationRecord.id}">
					${tlViolationRecord.driverName}
				</a></td>
				<td>
					${tlViolationRecord.telephone}
				</td>
				<td>
					${tlViolationRecord.violationRecord}
				</td>
				<td>
					<fmt:formatDate value="${tlViolationRecord.violationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlViolationRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlViolationRecord.remarks}
				</td>
				<shiro:hasPermission name="modules:tlViolationRecord:edit"><td>
    				<a href="${ctx}/modules/tlViolationRecord/form?id=${tlViolationRecord.id}">修改</a>
					<a href="${ctx}/modules/tlViolationRecord/delete?id=${tlViolationRecord.id}" onclick="return confirmx('确认要删除该违规记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>