<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验场酒店预定管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlTestSiteHotel/list?parentId=${tlTestSiteHotel.parentId}">试验场酒店预定列表</a></li>
		<shiro:hasPermission name="modules:tlTestSiteHotel:edit"><li><a href="${ctx}/modules/tlTestSiteHotel/form?parentId=${tlTestSiteHotel.parentId}">试验场酒店预定添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlTestSiteHotel" action="${ctx}/modules/tlTestSiteHotel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>房间类型：</label>
				<form:select path="roomType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('room_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>入住日期：</label>
				<input name="checkInDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlTestSiteHotel.checkInDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>房间类型</th>
				<th>预定数量</th>
				<th>入住日期</th>
				<th>退房日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlTestSiteHotel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlTestSiteHotel">
			<tr>
				<td><a href="${ctx}/modules/tlTestSiteHotel/form?id=${tlTestSiteHotel.id}">
					${fns:getDictLabel(tlTestSiteHotel.roomType, 'room_type', '')}
				</a></td>
				<td>
					${tlTestSiteHotel.reserveQuantity}
				</td>
				<td>
					<fmt:formatDate value="${tlTestSiteHotel.checkInDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlTestSiteHotel.checkOutDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${tlTestSiteHotel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestSiteHotel.remarks}
				</td>
				<shiro:hasPermission name="modules:tlTestSiteHotel:edit"><td>
    				<a href="${ctx}/modules/tlTestSiteHotel/form?id=${tlTestSiteHotel.id}">修改</a>
					<a href="${ctx}/modules/tlTestSiteHotel/delete?id=${tlTestSiteHotel.id}" onclick="return confirmx('确认要删除该试验场酒店预定吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>