<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验任务单管理</title>
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
		<c:if test="${not empty tlTestTaskList.id}"> 
			<li><a href="${ctx}/modules/tlTestTaskList/list?projectId=${tlTestTaskList.projectId}">试验任务单列表</a></li>
		</c:if>
		<li class="active"><a href="${ctx}/modules/tlTestTaskList/form?id=${tlTestTaskList.id}">试验任务单<shiro:hasPermission name="modules:tlTestTaskList:edit">${not empty tlTestTaskList.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlTestTaskList:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlTestTaskList" action="${ctx}/modules/tlTestTaskList/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="isBaoChang"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">项目编号：</label>
			<div class="controls">
				<form:input path="projectId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驾驶员：</label>
			<div class="controls">
				<form:select path="driverId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${list}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开始时间：</label>
			<div class="controls">
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${tlTestTaskList.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${tlTestTaskList.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
			<c:if test="${tlTestTaskList.isModify == 1}"> 
			<shiro:hasPermission name="modules:tlTestTaskList:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			</c:if>
			<c:if test="${not empty tlTestTaskList.id}"> 
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</c:if>
		</div>
	</form:form>
</body>
</html>