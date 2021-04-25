<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>场地控制管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlMidRoadGate/">场地控制列表</a></li>
		<shiro:hasPermission name="modules:tlMidRoadGate:edit"><li><a href="${ctx}/modules/tlMidRoadGate/form">场地控制添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlMidRoadGate" action="${ctx}/modules/tlMidRoadGate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>闸机编号：</label>
				<form:input path="roadGateNum" htmlEscape="false" maxlength="64" class="input-medium" value="${tlMidRoadGate.tlRoadGateId}"/>
			</li> --%>
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
				<th>闸机</th>
				<th>测试道路</th>
				<th>计费(元/小时)</th>
				<th>计费(元/千米)</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlMidRoadGate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlMidRoadGate">
			<tr>
				<td><a href="${ctx}/modules/tlMidRoadGate/form?id=${tlMidRoadGate.id}">
					${tlMidRoadGate.roadGateNum}
				</a>
				</td>
				<td>
					${fns:getDictLabel(tlMidRoadGate.testRoad, 'test_road', '')}
				</td>
				<td>
					${tlMidRoadGate.charge}
				</td>
				<td>
					${tlMidRoadGate.kmCharge}
				</td>
				<td>
					<fmt:formatDate value="${tlMidRoadGate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlMidRoadGate.remarks}
				</td>
				<shiro:hasPermission name="modules:tlMidRoadGate:edit"><td>
    				<a href="${ctx}/modules/tlMidRoadGate/form?id=${tlMidRoadGate.id}">修改</a>
					<a href="${ctx}/modules/tlMidRoadGate/delete?id=${tlMidRoadGate.id}" onclick="return confirmx('确认要删除该场地控制吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>