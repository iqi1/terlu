<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员资质管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlDriverQualification/">驾驶员资质列表</a></li>
		<shiro:hasPermission name="modules:tlDriverQualification:edit"><li><a href="${ctx}/modules/tlDriverQualification/form">驾驶员资质添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlDriverQualification" action="${ctx}/modules/tlDriverQualification/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idCard" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li>
			<li><label>发证日期：</label>
				<input name="issueDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tlDriverQualification.issueDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>证书编号：</label>
				<form:input path="certificateNum" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>性别</th>
				<th>身份证号</th>
				<th>文化程度</th>
				<th>发证日期</th>
				<th>证书编号</th>
				<th>职业(工种)及等级</th>
				<th>理论知识考试成绩</th>
				<th>操作技能考试成绩</th>
				<th>综合评审成绩</th>
				<th>评定成绩</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlDriverQualification:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlDriverQualification">
			<tr>
				<td><a href="${ctx}/modules/tlDriverQualification/form?id=${tlDriverQualification.id}">
					${tlDriverQualification.name}
				</a></td>
				<td>
					${fns:getDictLabel(tlDriverQualification.sex, 'sex', '')}
				</td>
				<td>
					${tlDriverQualification.idCard}
				</td>
				<td>
					${fns:getDictLabel(tlDriverQualification.eduLevel, 'edu_level', '')}
				</td>
				<td>
					<fmt:formatDate value="${tlDriverQualification.issueDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDriverQualification.certificateNum}
				</td>
				<td>
					${tlDriverQualification.occupation}
				</td>
				<td>
					${tlDriverQualification.theoryResult}
				</td>
				<td>
					${tlDriverQualification.skillResult}
				</td>
				<td>
					${tlDriverQualification.multipleResult}
				</td>
				<td>
					${tlDriverQualification.evaluateResult}
				</td>
				<td>
					<fmt:formatDate value="${tlDriverQualification.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlDriverQualification.remarks}
				</td>
				<shiro:hasPermission name="modules:tlDriverQualification:edit"><td>
    				<a href="${ctx}/modules/tlDriverQualification/form?id=${tlDriverQualification.id}">修改</a>
					<a href="${ctx}/modules/tlDriverQualification/delete?id=${tlDriverQualification.id}" onclick="return confirmx('确认要删除该驾驶员资质吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>