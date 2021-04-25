<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>试验测试申请表</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function() {
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
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
		<li><a href="${ctx}/modules/tlCustomBaseinfo/">试验测试申请表列表</a></li>
		<li class="active"><a
			href="${ctx}/modules/tlCustomBaseinfo/formBaseInfo?id=${tlCustomBaseinfo.id}">试验测试申请表基本信息<shiro:hasPermission
					name="modules:tlCustomBaseinfo:edit">${not empty tlCustomBaseinfo.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="modules:tlCustomBaseinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="tlCustomBaseinfo" action="${ctx}/modules/tlCustomBaseinfo/save" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />

			

		<div class="form-actions">
			<shiro:hasPermission name="modules:tlCustomBaseinfo:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>