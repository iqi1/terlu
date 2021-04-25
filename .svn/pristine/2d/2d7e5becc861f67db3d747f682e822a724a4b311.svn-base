<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员能力评估管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlDriverAblility/">驾驶员能力评估列表</a></li>
		<shiro:hasPermission name="modules:tlDriverAblility:edit"><li><a href="${ctx}/modules/tlDriverAblility/form">驾驶员能力评估添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlDriverAblility" action="${ctx}/modules/tlDriverAblility/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>驾龄：</label>
				<form:input path="driverAge" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:input path="sex" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>申请等级：</label>
				<form:select path="applyLevel" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('apply_level')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>委外单位名称：</label>
				<form:input path="comName" htmlEscape="false" maxlength="4" class="input-medium"/>
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
				<th>驾龄</th>
				<th>性别</th>
				<th>申请等级</th>
				<th>相关试验驾驶经验</th>
				<th>委外单位名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlDriverAblility:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlDriverAblility">
			<tr>
				<td><a href="${ctx}/modules/tlDriverAblility/form?id=${tlDriverAblility.id}">
					${tlDriverAblility.name}
				</a></td>
				<td>
					${tlDriverAblility.driverAge}
				</td>
				<td>
					${tlDriverAblility.sex}
				</td>
				<td>
					${fns:getDictLabel(tlDriverAblility.applyLevel, 'apply_level', '')}
				</td>
				<td>
					${tlDriverAblility.experience}
				</td>
				<td>
					${tlDriverAblility.comName}
				</td>
				<td>
					<fmt:formatDate value="${tlDriverAblility.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDriverAblility.remarks}
				</td>
				<shiro:hasPermission name="modules:tlDriverAblility:edit"><td>
    				<a href="${ctx}/modules/tlDriverAblility/form?id=${tlDriverAblility.id}">修改</a>
					<a href="${ctx}/modules/tlDriverAblility/delete?id=${tlDriverAblility.id}" onclick="return confirmx('确认要删除该驾驶员能力评估吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>