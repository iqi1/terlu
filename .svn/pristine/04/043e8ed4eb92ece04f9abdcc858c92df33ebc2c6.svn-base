<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>进出记录管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlInOutRecord/">进出记录列表</a></li>
		<shiro:hasPermission name="modules:tlInOutRecord:edit"><li><a href="${ctx}/modules/tlInOutRecord/form">进出记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlInOutRecord" action="${ctx}/modules/tlInOutRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>闸机id：</label>
				<form:input path="roadGateNum" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>卡号id：</label>
				<form:input path="cardNum" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>驾驶员：</label>
				<form:input path="driverName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li> --%>
			<li><label>进/出：</label>
				<form:select path="inOut" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('in_out')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>闸机id</th>
				<th>卡号id</th>
				<th>驾驶员</th>
				<th>进/出</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlInOutRecord:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlInOutRecord">
			<tr>
				<td><a href="${ctx}/modules/tlInOutRecord/form?id=${tlInOutRecord.id}">
					${tlInOutRecord.roadGateNum}
				</a></td>
				<td>
					${tlInOutRecord.cardNum}
				</td>
				<td>
					${tlInOutRecord.driverName}
				</td>
				<td>
					${fns:getDictLabel(tlInOutRecord.inOut, 'in_out', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlInOutRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlInOutRecord.remarks}
				</td>
				<shiro:hasPermission name="modules:tlInOutRecord:edit"><td>
    				<a href="${ctx}/modules/tlInOutRecord/form?id=${tlInOutRecord.id}">修改</a>
					<a href="${ctx}/modules/tlInOutRecord/delete?id=${tlInOutRecord.id}" onclick="return confirmx('确认要删除该进出记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>