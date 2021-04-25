<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员管理管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlCarTestGroundDriver/">驾驶员管理列表</a></li>
		<shiro:hasPermission name="modules:tlCarTestGroundDriver:edit"><li><a href="${ctx}/modules/tlCarTestGroundDriver/form">驾驶员管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlCarTestGroundDriver" action="${ctx}/modules/tlCarTestGroundDriver/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>联系电话：</label>
				<form:input path="telephoneDriver" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idcardPassport" htmlEscape="false" maxlength="18" class="input-medium"/>
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
				<th>联系电话</th>
				<th>身份证号</th>
				<th>驾驶证号</th>
				<th>初次领取驾照日期</th>
				<th>户籍</th>
				<!-- <th>年龄</th> -->
				<th>司机照片</th>
				<th>健康状况</th>
				<th>不良记录</th>
				<th>是否记满12分</th>
				<th>是否通过考试</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlCarTestGroundDriver:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlCarTestGroundDriver">
			<tr>
				<td><a href="${ctx}/modules/tlCarTestGroundDriver/form?id=${tlCarTestGroundDriver.id}">
					${tlCarTestGroundDriver.name}
				</a></td>
				<td>
					${tlCarTestGroundDriver.telephoneDriver}
				</td>
				<td>
					${tlCarTestGroundDriver.idcardPassport}
				</td>
				<td>
					${tlCarTestGroundDriver.driverLicenseNum}
				</td>
				<td>
					<fmt:formatDate value="${tlCarTestGroundDriver.firstLicenseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlCarTestGroundDriver.householdRegister}
				</td>
				<td>
					${tlCarTestGroundDriver.driverPhoto}
				</td>
				<td>
					${tlCarTestGroundDriver.health}
				</td>
				<td>
					${tlCarTestGroundDriver.badRecord}
				</td>
				<td>
					${fns:getDictLabel(tlCarTestGroundDriver.recordBelow12, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlCarTestGroundDriver.ispassExam, 'yse_no', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlCarTestGroundDriver.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlCarTestGroundDriver.remarks}
				</td>
				<shiro:hasPermission name="modules:tlCarTestGroundDriver:edit"><td>
    				<a href="${ctx}/modules/tlCarTestGroundDriver/form?id=${tlCarTestGroundDriver.id}">修改</a>
					<a href="${ctx}/modules/tlCarTestGroundDriver/delete?id=${tlCarTestGroundDriver.id}" onclick="return confirmx('确认要删除该驾驶员管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>