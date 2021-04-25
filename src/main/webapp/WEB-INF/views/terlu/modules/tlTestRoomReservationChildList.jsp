<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试包场预定管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlTestRoomReservationChild/">测试包场预定列表</a></li>
		<shiro:hasPermission name="modules:tlTestRoomReservationChild:edit"><li><a href="${ctx}/modules/tlTestRoomReservationChild/form?tlCustomBaseinfoId=${tlTestRoomReservationChild.tlCustomBaseinfoId}">测试包场预定添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlTestRoomReservationChild" action="${ctx}/modules/tlTestRoomReservationChild/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>测试道路：</label>
				<form:select path="testRoad" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>包场日期：</label>
				<input name="packageDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlTestRoomReservationChild.packageDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<!-- <th>父id</th> -->
				<th>测试道路</th>
				<th>包场日期</th>
				<th>包场时间</th>
				<th>同时使用场地车辆数目</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlTestRoomReservationChild:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlTestRoomReservationChild">
			<tr>
				<%-- <td><a href="${ctx}/modules/tlTestRoomReservationChild/form?id=${tlTestRoomReservationChild.id}">
					${tlTestRoomReservationChild.tlCustomBaseinfoId}
				</a></td> --%>
				<td>
					${fns:getDictLabel(tlTestRoomReservationChild.testRoad, 'test_road', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlTestRoomReservationChild.packageDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestRoomReservationChild.packageTime}
				</td>
				<td>
					${tlTestRoomReservationChild.carLimNum}
				</td>
				<td>
					<fmt:formatDate value="${tlTestRoomReservationChild.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestRoomReservationChild.remarks}
				</td>
				<shiro:hasPermission name="modules:tlTestRoomReservationChild:edit"><td>
    				<a href="${ctx}/modules/tlTestRoomReservationChild/form?id=${tlTestRoomReservationChild.id}">修改</a>
					<a href="${ctx}/modules/tlTestRoomReservationChild/delete?id=${tlTestRoomReservationChild.id}" onclick="return confirmx('确认要删除该测试包场预定吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>