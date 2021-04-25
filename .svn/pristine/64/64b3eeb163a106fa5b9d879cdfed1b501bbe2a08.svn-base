<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验测试申请表管理</title>
	<meta name="decorator" content="default"/>
	<link rel="stylesheet"
	href="${ctxStatic}/jquery-ui/1.8.16/themes/base/jquery.ui.all.css"
	type="text/css">

<script src="${ctxStatic}/jquery-ui/1.8.16/ui/jquery.ui.widget.js"
	type="text/javascript"></script>
<script src="${ctxStatic}/jquery-ui/1.8.16/ui/jquery.ui.tabs.js"
	type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/modules/tlFuelManage/audit?id=${tlFuelManage.id}">试验测试申请审核</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlFuelManage" action="${ctx}/modules/tlFuelManage/audit" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden id="flag" path="status"/>
		<sys:message content="${message}"/>
		<div class="form-actions">
		<table id="" border="0" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
				<thead>
					<tr>
						<th>审核操作</th>
						<th>审批意见</th>

					</tr>
				</thead>
				<tbody>
			<tr>
			<td>
			<c:if test="${empty tlFuelManage.procInsId}"> 
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="提交审核" onclick="$('#flag').val(2)"/>&nbsp;
			</c:if>
			<c:if test="${not empty tlFuelManage.procName && tlFuelManage.status == 3}"> 

			<shiro:hasPermission name="modules:tlFuelManage:audit">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="同 意" onclick="$('#flag').val(1)"/>&nbsp;
			
			<c:if test="${tlFuelManage.procName != '领队试验员'}"> 
			<input id="btnSubmit" class="btn btn-inverse" type="submit" value="驳 回" onclick="$('#flag').val(0)"/>&nbsp;
			</c:if>
			
			</shiro:hasPermission>
			</c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
			<td>

			<div class="controls">
				<form:textarea path="comment" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
			</td>
			</tr>
			</tbody>
		</table>
		</div>
	
		<act:histoicFlow procInsId="${tlFuelManage.procInsId}"/>
	</form:form>
	
	<script type="text/javascript">
	
	$(function() {
		$("#tabs").tabs();
		$(function() {
			$("#tabs").tabs({
				event : "mouseover"
			});
		});
	});	
	</script>
</body>
</html>