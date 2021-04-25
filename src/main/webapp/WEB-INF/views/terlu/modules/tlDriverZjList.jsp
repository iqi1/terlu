<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员证件管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlDriverZj/">驾驶员证件列表</a></li>
		<shiro:hasPermission name="modules:tlDriverZj:edit"><li><a href="${ctx}/modules/tlDriverZj/form">驾驶员证件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlDriverZj" action="${ctx}/modules/tlDriverZj/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>显示名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<%-- <li><label>证件照片：</label>
				<form:input path="photo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li> --%>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>身份证照片</th>
				<th>电话</th>
				<th>姓名</th>
				<th>民族</th>
				<th>住址</th>
				<th>身份证号码</th>
				<th>出生年月</th>
				<th>性别</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlDriverZj:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlDriverZj">
			<tr>
				<td><a href="${ctx}/modules/tlDriverZj/form?id=${tlDriverZj.id}">
					<img style="height:120px;width:150px;" src="${ctx}/modules/tlDriverZj/showIdcard?id=${tlDriverZj.id}"/>
				</a></td>
				<td>
					${tlDriverZj.tel}
				</td>
				<td>
					${tlDriverZj.name}
				</td>
				<td>
					${tlDriverZj.nation}
				</td>
				<td>
					${tlDriverZj.address}
				</td>
				<td>
					${tlDriverZj.IDcard}
				</td>
				<td>
					${tlDriverZj.birth}
				</td>
				<td>
					${tlDriverZj.sex}
				</td>
				<td>
					<fmt:formatDate value="${tlDriverZj.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					${tlDriverZj.remarks}
				</td> --%>
				<td>
					${not empty tlDriverZj.procInsId ?'已经提交':'没提交'}
					<c:if test="${not empty tlDriverZj.procInsId}"> 
					 ${empty tlDriverZj.procName ? ' 通过审核':tlDriverZj.procName}
					</c:if>
				</td>
				<td>
				<shiro:hasPermission name="modules:tlDriverZj:audit">
					<a href="${ctx}/modules/tlDriverZj/formAudit?id=${tlDriverZj.id}&status=${tlDriverZj.status}">详情</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="modules:tlDriverZj:edit">
					<%-- <c:if test="${empty tlDriverZj.procInsId || tlDriverZj.procName == '修改'}"> 
    					<a href="${ctx}/modules/tlDriverZj/form?id=${tlDriverZj.id}">修改</a>
					</c:if> --%>
    				<a href="${ctx}/modules/tlDriverZj/form?id=${tlDriverZj.id}">修改</a>
					<a href="${ctx}/modules/tlDriverZj/delete?id=${tlDriverZj.id}" onclick="return confirmx('确认要删除该驾驶员证件吗？', this.href)">删除</a>
				</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>