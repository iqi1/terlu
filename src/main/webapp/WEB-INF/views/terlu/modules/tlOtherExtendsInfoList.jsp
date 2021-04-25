<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>其他信息管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlOtherExtendsInfo/list?parentId=${tlOtherExtendsInfo.parentId}">其他信息列表</a></li>
		<c:if test="${empty page.list}"> 
		<shiro:hasPermission name="modules:tlOtherExtendsInfo:edit"><li><a href="${ctx}/modules/tlOtherExtendsInfo/form?parentId=${tlOtherExtendsInfo.parentId}">其他信息添加</a></li></shiro:hasPermission>
		</c:if>
	</ul>
	<form:form id="searchForm" modelAttribute="tlOtherExtendsInfo" action="${ctx}/modules/tlOtherExtendsInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>是否包含高危险性试验？：</label>
				<form:select path="isdanger" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>是否包含高危险性试验？</th>
				<th>是否需要在场地内摄像或摄影</th>
				<th>危险性描述</th>
				<th>安全措施说明</th>
				<th>公共车间</th>
				<th>保密车间</th>
				<th>会议室</th>
				<th>具体要求</th>
				<th>是否需要租车服务</th>
				<th>是否需要租用试验驾驶员</th>
				<th>其他特殊服务</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlOtherExtendsInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlOtherExtendsInfo">
			<tr>
				<td><a href="${ctx}/modules/tlOtherExtendsInfo/form?id=${tlOtherExtendsInfo.id}">
					${fns:getDictLabel(tlOtherExtendsInfo.isdanger, 'yes_no', '')}
				</a></td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.iscamera, 'yes_no', '')}
				</td>
				<td>
					${tlOtherExtendsInfo.dangerDescription}
				</td>
				<td>
					${tlOtherExtendsInfo.safeExplain}
				</td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.publicWorkshop, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.confidentialWorkshop, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.meetingRoom, 'yes_no', '')}
				</td>
				<td>
					${tlOtherExtendsInfo.specificRequirement}
				</td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.isCarRentalService, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(tlOtherExtendsInfo.isNeedHireTestDriver, 'yes_no', '')}
				</td>
				<td>
					${tlOtherExtendsInfo.otherSpecialServices}
				</td>
				<td>
					<fmt:formatDate value="${tlOtherExtendsInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlOtherExtendsInfo.remarks}
				</td>
				<shiro:hasPermission name="modules:tlOtherExtendsInfo:edit"><td>
    				<a href="${ctx}/modules/tlOtherExtendsInfo/form?id=${tlOtherExtendsInfo.id}">修改</a>
					<a href="${ctx}/modules/tlOtherExtendsInfo/delete?id=${tlOtherExtendsInfo.id}" onclick="return confirmx('确认要删除该其他信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>