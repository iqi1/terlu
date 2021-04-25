<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验预约管理</title>
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
		<li class="active"><a href="${ctx}/modules/tsAppointment/">试验预约列表</a></li>
		<shiro:hasPermission name="modules:tsAppointment:edit"><li><a href="${ctx}/modules/tsAppointment/form">试验预约添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tsAppointment" action="${ctx}/modules/tsAppointment/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>单位名称：</label>
				<form:input path="unitName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>联系人姓名：</label>
				<form:input path="contactName" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>邮箱：</label>
				<form:input path="email" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>手机：</label>
				<form:input path="mobile" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tsAppointment.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>单位名称</th>
				<th>联系人姓名</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>手机</th>
				<th>性别</th>
				<th>创建时间</th>
				<shiro:hasPermission name="modules:tsAppointment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tsAppointment">
			<tr>
				<td><a href="${ctx}/modules/tsAppointment/form?id=${tsAppointment.id}">
					${tsAppointment.unitName}
				</a></td>
				<td>
					${tsAppointment.contactName}
				</td>
				<td>
					${tsAppointment.email}
				</td>
				<td>
					${tsAppointment.phone}
				</td>
				<td>
					${tsAppointment.mobile}
				</td>
				<td>
					${fns:getDictLabel(tsAppointment.sex, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${tsAppointment.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="modules:tsAppointment:edit"><td>
    				<a href="${ctx}/modules/tsAppointment/form?id=${tsAppointment.id}">修改</a>
					<a href="${ctx}/modules/tsAppointment/delete?id=${tsAppointment.id}" onclick="return confirmx('确认要删除该试验预约吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>