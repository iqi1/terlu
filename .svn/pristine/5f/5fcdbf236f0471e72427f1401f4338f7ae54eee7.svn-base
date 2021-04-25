<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>驾驶员证件管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resource/jslib/removeBackground.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
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
			$("#fileupload1").change(function(){
        		readURL(this);
        		flag = 1;
    		});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/modules/tlDriverZj/">驾驶员证件列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlDriverZj/form?id=${tlDriverZj.id}">驾驶员证件<shiro:hasPermission name="modules:tlDriverZj:edit">${not empty tlDriverZj.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlDriverZj:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlDriverZj" action="${ctx}/modules/tlDriverZj/save" method="post" class="form-horizontal" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<%-- <div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>	 --%>
		
		<div class="control-group">
			<label class="control-label">身份证图片：</label>
			<div class="controls">
				<td><input id="fileupload1" type="file" name="files"></td>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证预览：</label>
			<div class="controls">
				<td><img style="height:120px;width:150px;" src="${ctx}/modules/tlDriverZj/showIdcard?id=${tlDriverZj.id}" id="target"/></td>
				<td style="display:none;"><canvas id="myCanvasTag" width="150" height="20" ></canvas></td>
				<td><input id="urlbase64" type="hidden" name="urlbase64"></td>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				<form:input path="tel" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlDriverZj:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>