<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试道路请求管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/terlu/css/seat.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic}/terlu/js/tlRequestTestRoad.js"></script>
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
		<li><a href="${ctx}/modules/tlRequestTestRoad/">测试道路请求列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlRequestTestRoad/form?id=${tlRequestTestRoad.id}">测试道路请求<shiro:hasPermission name="modules:tlRequestTestRoad:edit">${not empty tlRequestTestRoad.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlRequestTestRoad:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlRequestTestRoad" action="${ctx}/modules/tlRequestTestRoad/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden id="selects" path="selects"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">项目：</label>
			<div class="controls">
				<form:select path="projectId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${list}" itemLabel="companyName" itemValue="id" htmlEscape="false"/>
				</form:select>
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
			<label class="control-label">测试日期：</label>
			<div class="controls">
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" onfocus="initTestRoadBox(this.realValue);"/>
<!--  				<span class="help-inline"><font color="red">*</font> </span>-->
			</div>
		</div>
<!--  		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${tlRequestTestRoad.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>-->
		
		<div>
		   <div class="seat_show" style="margin-left: unset;">
	    	<ul>
	        	<li>
	            	<i></i>
	                <span>可选</span>
	            </li>
	            <li>
	            	<i></i>
	                <span>已分</span>
	            </li>
	            <li>
	            	<i></i>
	                <span>已选</span>
	            </li>
	        </ul>
   		 </div>
<div>

<div id="roads" ></div>

</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlRequestTestRoad:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
		
	</form:form>
	
	<script type="text/javascript">
	
	$('input[name="startTime"]').on('input propertychange', function() {
	    alert(2)
	})


	
	</script>
</body>
</html>