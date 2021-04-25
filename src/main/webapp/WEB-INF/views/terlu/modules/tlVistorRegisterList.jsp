<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>到访人员信息登记管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlVistorRegister/list?parentId=${tlVistorRegister.parentId}">到访人员信息登记列表</a></li>
		<shiro:hasPermission name="modules:tlVistorRegister:edit"><li><a href="${ctx}/modules/tlVistorRegister/form?parentId=${tlVistorRegister.parentId}">到访人员信息登记添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlVistorRegister" action="${ctx}/modules/tlVistorRegister/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证/护照</th>
				<th>是否为试验驾驶员</th>
				<th>是否申请试验场驾驶许可证</th>
				<th>是否参加安全简介培训</th>
				<th>是否入住试验场酒店</th>
				<th>更新时间</th>
				<shiro:hasPermission name="modules:tlVistorRegister:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlVistorRegister">
			<tr>
				<td><a href="${ctx}/modules/tlVistorRegister/form?id=${tlVistorRegister.id}">
					${tlVistorRegister.name}
				</a></td>
				<td>
					${tlVistorRegister.idcardPassport}
				</td>
				<td>
					${fns:getDictLabel(tlVistorRegister.driver, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlVistorRegister.applyLicense, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlVistorRegister.joinSafetrain, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlVistorRegister.checkinHotel, 'yes_no', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlVistorRegister.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="modules:tlVistorRegister:edit"><td>
    				<a href="${ctx}/modules/tlVistorRegister/form?id=${tlVistorRegister.id}">修改</a>
					<a href="${ctx}/modules/tlVistorRegister/delete?id=${tlVistorRegister.id}" onclick="return confirmx('确认要删除该到访人员信息登记吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>