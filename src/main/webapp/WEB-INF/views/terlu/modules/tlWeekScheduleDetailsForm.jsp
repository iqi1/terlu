<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划排班管理</title>
	<meta name="decorator" content="default"/>
	
	<link href="${ctxStatic}/terlu/css/seat.css" type="text/css" rel="stylesheet" />

	<script type="text/javascript" src="${ctxStatic}/terlu/js/layer.js"></script>

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
		<li><a href="${ctx}/modules/tlWeekScheduleDetails/">计划排班列表</a></li>
		<li class="active"><a href="${ctx}/modules/tlWeekScheduleDetails/form?id=${tlWeekScheduleDetails.id}">计划排班<shiro:hasPermission name="modules:tlWeekScheduleDetails:edit">${not empty tlWeekScheduleDetails.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="modules:tlWeekScheduleDetails:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlWeekScheduleDetails" action="${ctx}/modules/tlWeekScheduleDetails/save" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<form:hidden id="selects" path="selects"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">计划周：</label>
			<div class="controls">
				<form:select path="msid" class="input-medium  required">
					<form:option value="" label=""/>
					<form:options items="${weekList}" itemLabel="mid" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<!--  <div class="control-group">
			<label class="control-label">项目id：</label>
			<div class="controls">
				<form:input path="projectId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>-->
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
				<input name="testDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${tlWeekScheduleDetails.testDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试时序：</label>
			<div class="controls">
				<form:input path="timeSeries" htmlEscape="false" maxlength="8" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		
		<div>
		
		   <div class="seat_show">
	    	<ul>
	        	<li>
	            	<i></i>
	                <span>可选</span>
	            </li>
	            <li>
	            	<i></i>
	                <span>已售</span>
	            </li>
	            <li>
	            	<i></i>
	                <span>已选</span>
	            </li>
	        </ul>
   		 </div>
    
		    <div class="seat_choose">
		    	<div class="number" id="num"></div>
		    	<div class="seats" id="seats"></div>
		        
		    </div>
		
		
		
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="modules:tlWeekScheduleDetails:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	
		<script type="text/javascript">

		$(function(){
			var html='';
				html+='<ul class="touchs" id="touchs">';
				for(var i=1; i<=204; i++){
					var selected = (i>91&&i<98 ? 'selected' : '');
					html+='<li class="'+selected+'">';
					html+='<input type="checkbox" name="'+i+'" id="seat-'+i+'" />';
					html+='<label for="seat-'+i+'"></label>';
					html+='</li>';
				}
				html+='</ul>';
				$('#seats').html(html);
				
			
			$('.selected').children('input').attr({'disabled':'disabled','checked':'checked'});
			
				
			$('.seats li input').on('click',function(){
				var selects = $('.seats li').not('.selected').children('input:checked')
				var checklen = selects.length;
				console.log(checklen);
				
				console.log(checklen);
				var ids = "";
				for(var ii = 0 ; ii < selects.length; ii ++){
					console.log(selects[ii].id);
					ids += selects[ii].name;
					ids += ":";
				}
				$('#selects').val(ids);

			});
			
			
			//公用弹出层
			function popu(content){
				layer.open({
					content: content
					,skin: 'msg'
					,time: 3
				});	
			}
			
			
			var num='';
				num+='<ul>';
				for(var i=1; i<=12; i++){
					num+='<li>'+i+'</li>';
				}
				html+='</ul>';
				$('#num').html(num);
				
			var crossnum='';
				crossnum+='<ul>';
				for(var j=1; j<=17; j++){
					crossnum+='<li>'+j+'</li>';
				}
				html+='</ul>';
				$('#crossnum').html(crossnum);
			
			
			
		})
		
		
		
		</script>
</body>
</html>