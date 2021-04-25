<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>进出记录管理</title>
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
      <script src="js/jquery.min.js"></script>
      <script type="text/javascript">
          $(function(){
              $("#driver").click(function(){
            	  $.ajax({
           		    url: "http://localhost:8080/terlu/a?login",
           		    type: "POST",
           		    data:{
           		      driverId:'driverId',
           		      //cardId:'cardId'
           		    },
           		    cache:false,
           		    dataType: "json",
           		    success: function(data){
           		    },
           		    error:function(err){
           		    }
           		  });
              });
          });
      </script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/modules/tlInOutRecord/">进出记录列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlInOutRecord/form?id=${tlInOutRecord.id}">进出记录<shiro:hasPermission name="modules:tlInOutRecord:edit">${not empty tlInOutRecord.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlInOutRecord:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlInOutRecord" action="${ctx}/modules/tlInOutRecord/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">闸机编号：</label>
			<div class="controls">
				<form:select path="roadGateId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${listrg}" itemLabel="gateNum" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">卡号：</label>
			<div class="controls">
				<form:select path="cardId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${listcs}" itemLabel="cardNum" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驾驶员：</label>
			<div class="controls">
				<form:select path="driverId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${listDriver}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">进/出：</label>
			<div class="controls">
				<form:select path="inOut" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('in_out')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
			<shiro:hasPermission name="modules:tlInOutRecord:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	
</body>
</html>