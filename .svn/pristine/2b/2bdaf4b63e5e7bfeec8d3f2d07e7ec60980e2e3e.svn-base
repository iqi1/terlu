<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>闸机信息管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlRoadGate/">闸机信息列表</a></li>
		<shiro:hasPermission name="modules:tlRoadGate:edit"><li><a href="${ctx}/modules/tlRoadGate/form">闸机信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlRoadGate" action="${ctx}/modules/tlRoadGate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>闸机编号：</label>
				<form:input path="gateNum" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<%-- <li><label>卡记录：</label>
				<form:input path="cardRecord" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>闸机编号</th>
				<th>设备编号</th>
				<!-- <th>进出记录</th>
				<th>卡记录</th>
				<th>进场时间</th>
				<th>出场时间</th> -->
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlRoadGate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlRoadGate">
			<tr>
				<td><a href="${ctx}/modules/tlRoadGate/form?id=${tlRoadGate.id}">
					${tlRoadGate.gateNum}
				</a></td>
				<td>
					${tlRoadGate.deviceNum}
				</td>
				<%-- <td>
					${fns:getDictLabel(tlRoadGate.inOutRecord, 'in_out', '')}
				</td>
				<td>
					${tlRoadGate.cardRecord}
				</td>
				<td>
					<fmt:formatDate value="${tlRoadGate.comeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlRoadGate.outDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					<fmt:formatDate value="${tlRoadGate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlRoadGate.remarks}
				</td>
				<shiro:hasPermission name="modules:tlRoadGate:edit"><td>
    				<a href="${ctx}/modules/tlRoadGate/form?id=${tlRoadGate.id}">修改</a>
					<a href="${ctx}/modules/tlRoadGate/delete?id=${tlRoadGate.id}" onclick="return confirmx('确认要删除该闸机信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>