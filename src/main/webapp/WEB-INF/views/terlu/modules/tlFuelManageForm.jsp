<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>加油申请管理</title>
	<meta name="decorator" content="default"/>
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
		<c:if test="${not empty tlFuelManage.id}"> 
			<li><a href="${ctx}/modules/tlFuelManage/list?project=${tlFuelManage.project}">加油申请列表</a></li>
		</c:if>
		<li class="active"><a href="${ctx}/modules/tlFuelManage/form?id=${tlFuelManage.id}">加油申请<shiro:hasPermission name="modules:tlFuelManage:edit">${not empty tlFuelManage.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlFuelManage:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlFuelManage" action="${ctx}/modules/tlFuelManage/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<%-- <div class="control-group">
			<label class="control-label">项目编号：</label>
			<div class="controls">
				<form:input path="parentId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">项目名称：</label>
			<div class="controls">
				<form:select path="project" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${listCu}" itemLabel="companyName" itemValue="id" htmlEscape="false"/>
				</form:select>
				<%-- <form:input path="project" htmlEscape="false" maxlength="64" class="input-xlarge required"/> --%>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试道路：</label>
			<div class="controls">
				<form:select path="testRoad" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">接单人：</label>
			<div class="controls">
				<form:input path="leadTester" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">燃料类型：</label>
			<div class="controls">
				<form:select path="fuelType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fuel_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">加油量：</label>
			<div class="controls">
				<form:input path="consume" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlFuelManage:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>