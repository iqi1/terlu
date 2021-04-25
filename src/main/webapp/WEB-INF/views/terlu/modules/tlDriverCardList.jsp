<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员身份证管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlDriverCard/">驾驶员身份证列表</a></li>
		<shiro:hasPermission name="modules:tlDriverCard:edit"><li><a href="${ctx}/modules/tlDriverCard/form">驾驶员身份证添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlDriverCard" action="${ctx}/modules/tlDriverCard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>证件照片：</label>
				<form:input path="photo" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>证件照片</th>
				<th>姓名</th>
				<th>民族</th>
				<th>住址</th>
				<th>身份证号</th>
				<th>出生年月</th>
				<th>性别</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlDriverCard:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlDriverCard">
			<tr>
				<td><a href="${ctx}/modules/tlDriverCard/form?id=${tlDriverCard.id}">
					${tlDriverCard.photo}
				</a></td>
				<td>
					<fmt:formatDate value="${tlDriverCard.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDriverCard.remarks}
				</td>
				<shiro:hasPermission name="modules:tlDriverCard:edit"><td>
    				<a href="${ctx}/modules/tlDriverCard/form?id=${tlDriverCard.id}">修改</a>
					<a href="${ctx}/modules/tlDriverCard/delete?id=${tlDriverCard.id}" onclick="return confirmx('确认要删除该驾驶员身份证吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
				<td>
					${tlDriverCard.name}
				</td>
				<td>
					${tlDriverCard.nation}
				</td>
				<td>
					${tlDriverCard.address}
				</td>
				<td>
					${tlDriverCard.IDcard}
				</td>
				<td>
					${tlDriverCard.birth}
				</td>
				<td>
					${tlDriverCard.sex}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>