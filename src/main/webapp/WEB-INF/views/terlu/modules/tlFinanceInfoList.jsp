<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>财务信息登记管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlFinanceInfo/list?parentId=${tlFinanceInfo.parentId}">财务信息登记列表</a></li>
		<c:if test="${empty page.list}"> 
		<shiro:hasPermission name="modules:tlFinanceInfo:edit"><li><a href="${ctx}/modules/tlFinanceInfo/form?parentId=${tlFinanceInfo.parentId}">财务信息登记添加</a></li></shiro:hasPermission>
		</c:if>
	</ul>
	<form:form id="searchForm" modelAttribute="tlFinanceInfo" action="${ctx}/modules/tlFinanceInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>发票抬头：</label>
				<form:input path="invoiceRise" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>增值税号：</label>
				<form:input path="vatNumber" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>发票接收人：</label>
				<form:input path="invoiceReceiver" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>发票接收人联系电话：</label>
				<form:input path="telInvRecever" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>发票抬头</th>
				<th>增值税号</th>
				<th>发票接收人</th>
				<th>发票接收人联系电话</th>
				<th>邮箱</th>
				<th>开户银行名称</th>
				<th>开户行账号</th>
				<th>公司注册地址</th>
				<th>发票接收地址</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlFinanceInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlFinanceInfo">
			<tr>
				<td><a href="${ctx}/modules/tlFinanceInfo/form?id=${tlFinanceInfo.id}">
					${tlFinanceInfo.invoiceRise}
				</a></td>
				<td>
					${tlFinanceInfo.vatNumber}
				</td>
				<td>
					${tlFinanceInfo.invoiceReceiver}
				</td>
				<td>
					${tlFinanceInfo.telInvRecever}
				</td>
				<td>
					${tlFinanceInfo.email}
				</td>
				<td>
					${tlFinanceInfo.bankName}
				</td>
				<td>
					${tlFinanceInfo.accountBank}
				</td>
				<td>
					${tlFinanceInfo.registeredAddress}
				</td>
				<td>
					${tlFinanceInfo.invoiceReceiveAddress}
				</td>
				<td>
					<fmt:formatDate value="${tlFinanceInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlFinanceInfo.remarks}
				</td>
				<shiro:hasPermission name="modules:tlFinanceInfo:edit"><td>
    				<a href="${ctx}/modules/tlFinanceInfo/form?id=${tlFinanceInfo.id}">修改</a>
					<a href="${ctx}/modules/tlFinanceInfo/delete?id=${tlFinanceInfo.id}" onclick="return confirmx('确认要删除该财务信息登记吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>