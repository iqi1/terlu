<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>电子签名管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resource/jslib/removeBackground.js"></script>
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
			
			$("#fileupload").change(function(){
        		readURL(this);
        		flag = 1;
    		});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/modules/tlSeal/">电子签名列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlSeal/form?id=${tlSeal.id}">电子签名<shiro:hasPermission name="modules:tlSeal:edit">${not empty tlSeal.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlSeal:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlSeal" action="${ctx}/modules/tlSeal/save" method="post" class="form-horizontal" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">显示名称：</label>
			<div class="controls">
				<form:input path="alias" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签名的密码：</label>
			<div class="controls">
				<form:input path="sealPassword" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户id：</label>
			<div class="controls">
				<sys:treeselect id="user" name="user.id" value="${tlSeal.user.id}" labelName="user.name" labelValue="${tlSeal.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<!--  <div class="control-group">
			<label class="control-label">印章图片：</label>
			<div class="controls">
				<form:input path="image" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>-->
		<div class="control-group">
			<label class="control-label">签名图片：</label>
			<div class="controls">
				<td><input id="fileupload" type="file" name="files"></td>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签名预览：</label>
			<div class="controls">
				<td><img style="height:120px;width:150px;" src="${ctx}/modules/tlSeal/showImg?id=${tlSeal.id}" id="target"/></td>
				<td style="display:none;"><canvas id="myCanvasTag" width="150" height="20" ></canvas></td>
				<td><input id="urlbase64" type="hidden" name="urlbase64"></td>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlSeal:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>