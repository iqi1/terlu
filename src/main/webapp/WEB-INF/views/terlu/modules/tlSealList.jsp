<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>电子签名管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlSeal/">电子签名列表</a></li>
		<shiro:hasPermission name="modules:tlSeal:edit"><li><a href="${ctx}/modules/tlSeal/form">电子签名添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlSeal" action="${ctx}/modules/tlSeal/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>显示名称：</label>
				<form:input path="alias" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户id：</label>
				<sys:treeselect id="user" name="user.id" value="${tlSeal.user.id}" labelName="user.name" labelValue="${tlSeal.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>显示名称</th>
				<th>印章图片</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlSeal:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlSeal">
			<tr>
				<td><a href="${ctx}/modules/tlSeal/form?id=${tlSeal.id}">
					${tlSeal.alias}
				</a>
				</td>
				<td>
					<img style="height:120px;width:150px;" src="${ctx}/modules/tlSeal/showImg?id=${tlSeal.id}"/>
				</td>
				<td>
					<fmt:formatDate value="${tlSeal.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlSeal.remarks}
				</td>
				<shiro:hasPermission name="modules:tlSeal:edit"><td>
    				<a href="${ctx}/modules/tlSeal/form?id=${tlSeal.id}">修改</a>
					<a href="${ctx}/modules/tlSeal/delete?id=${tlSeal.id}" onclick="return confirmx('确认要删除该电子签名吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>