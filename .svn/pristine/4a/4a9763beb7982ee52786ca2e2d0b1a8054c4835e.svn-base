<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>寄送信息登记管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlSendAddress/list?parentId=${tlSendAddress.parentId}">寄送信息登记列表</a></li>
		<c:if test="${empty page.list}"> 
		<shiro:hasPermission name="modules:tlSendAddress:edit"><li><a href="${ctx}/modules/tlSendAddress/form?parentId=${tlSendAddress.parentId}">寄送信息登记添加</a></li></shiro:hasPermission>
		</c:if>
	</ul>
	<form:form id="searchForm" modelAttribute="tlSendAddress" action="${ctx}/modules/tlSendAddress/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>寄件人姓名：</label>
				<form:input path="senderName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>寄件人电话：</label>
				<form:input path="telSender" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>寄送地址</th>
				<th>寄送联系电话</th>
				<th>寄件人姓名</th>
				<th>收件人姓名</th>
				<th>寄件人电话</th>
				<th>收件人电话</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlSendAddress:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlSendAddress">
			<tr>
				<td><a href="${ctx}/modules/tlSendAddress/form?id=${tlSendAddress.id}">
					${tlSendAddress.sendAddress}
				</a></td>
				<td>
					${tlSendAddress.telSend}
				</td>
				<td>
					${tlSendAddress.senderName}
				</td>
				<td>
					${tlSendAddress.receiverName}
				</td>
				<td>
					${tlSendAddress.telSender}
				</td>
				<td>
					${tlSendAddress.telReceiver}
				</td>
				<td>
					<fmt:formatDate value="${tlSendAddress.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlSendAddress.remarks}
				</td>
				<shiro:hasPermission name="modules:tlSendAddress:edit"><td>
    				<a href="${ctx}/modules/tlSendAddress/form?id=${tlSendAddress.id}">修改</a>
					<a href="${ctx}/modules/tlSendAddress/delete?id=${tlSendAddress.id}" onclick="return confirmx('确认要删除该寄送信息登记吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>