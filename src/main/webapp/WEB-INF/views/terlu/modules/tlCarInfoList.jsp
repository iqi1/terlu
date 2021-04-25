<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆信息登记管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlCarInfo/list?parentId=${tlCarInfo.parentId}">车辆信息登记列表</a></li>
		<shiro:hasPermission name="modules:tlCarInfo:edit"><li><a href="${ctx}/modules/tlCarInfo/form?parentId=${tlCarInfo.parentId}">车辆信息登记添加</a></li></shiro:hasPermission>
	</ul>
	<!--  -->
	<form:form id="searchForm" modelAttribute="tlCarInfo" action="${ctx}/modules/tlCarInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>VIN后6位：</label>
				<form:input path="vinAfterSix" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车辆类型</th>
				<th>载重类型</th>
				<th>车重</th>
				<th>最大轴重</th>
				<th>燃料类型</th>
				<th>预计消耗量</th>
				<th>颜色/牌照</th>
				<th>品牌型号</th>
				<th>VIN后6位</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlCarInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlCarInfo">
			<tr>
				<td><a href="${ctx}/modules/tlCarInfo/form?id=${tlCarInfo.id}">
					${fns:getDictLabel(tlCarInfo.carType, 'car_type', '')}
				</a></td>
				<td>
					${fns:getDictLabel(tlCarInfo.loadType, 'load_type', '')}
				</td>
				<td>
					${tlCarInfo.carWeight}
				</td>
				<td>
					${tlCarInfo.maxAxleLoad}
				</td>
				<td>
					${fns:getDictLabel(tlCarInfo.fuelType, 'fuel_type', '')}
				</td>
				<td>
					${tlCarInfo.estimatedConsumption}
				</td>
				<td>
					${tlCarInfo.colorLicense}
				</td>
				<td>
					${tlCarInfo.brandModel}
				</td>
				<td>
					${tlCarInfo.vinAfterSix}
				</td>
				<td>
					<fmt:formatDate value="${tlCarInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlCarInfo.remarks}
				</td>
				<shiro:hasPermission name="modules:tlCarInfo:edit"><td>
    				<a href="${ctx}/modules/tlCarInfo/form?id=${tlCarInfo.id}">修改</a>
					<a href="${ctx}/modules/tlCarInfo/delete?id=${tlCarInfo.id}" onclick="return confirmx('确认要删除该车辆信息登记吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>