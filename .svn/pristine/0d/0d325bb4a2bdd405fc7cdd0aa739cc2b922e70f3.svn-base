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
		<li class="active"><a href="${ctx}/modules/tlCustomBaseinfo/audit?id=${tlCustomBaseinfo.id}">试验测试申请审核</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tlCustomBaseinfo" action="${ctx}/modules/tlCustomBaseinfo/audit" method="post" class="form-horizontal">
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
			<c:if test="${empty tlCustomBaseinfo.procInsId}"> 
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="提交审核" onclick="$('#flag').val(2)"/>&nbsp;
			</c:if>
			<c:if test="${not empty tlCustomBaseinfo.procName && tlCustomBaseinfo.status == 3}"> 

			<shiro:hasPermission name="modules:tlCustomBaseinfo:audit">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="同 意" onclick="$('#flag').val(1)"/>&nbsp;
			
			<c:if test="${tlCustomBaseinfo.procName != '领队试验员'}"> 
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
	
		<div id="tabs" style="width: 100%; height: 100%"
			class="ui-tabs ui-widget ui-widget-content ui-corner-all">

			<ul style="float: left"
				class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
				<li class="ui-state-default ui-corner-top"><a href="#tabs-0"><span>基本信息</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-4"><span>财务和邮递信息</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-1"><span>到访人员和酒店</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-2"><span>车辆信息</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-3"><span>测试道路</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-5"><span>其它信息</span></a></li>
				<li class="ui-state-default ui-corner-top"><a href="#tabs-6"><span>驾驶员分配</span></a></li>
			</ul>
			
			<div id="tabs-6"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-6" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>测试道路</th>
							<th>测试包场</th>
							<th>驾驶员</th>
							<th>开始时间</th>
							<th>结束时间</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${listTTL}" var="tlTestTaskList">
						<tr>
							<td>
								${tlTestTaskList.companyName}
							</td>	
							<td>
								${fns:getDictLabel(tlTestTaskList.testRoad, 'test_road', '')}
							</td>
							<td>
								${fns:getDictLabel(tlTestTaskList.isBaoChang, 'yes_no', '')}
							</td>
							<td>
								${tlTestTaskList.driverName}
							</td>
							<td>
								<fmt:formatDate value="${tlTestTaskList.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<fmt:formatDate value="${tlTestTaskList.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
			
						</tr>
					</c:forEach>
					
					</tbody>
				</table>
			</div>

			<div id="tabs-5"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-5" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<tbody>
						<tr>
							<td colspan="11"
								style="width: 380px; height: 11px; font-size: 10ps">是否包含高危险性试验？(8)</td>
							<td colspan="11"
								style="width: 69px; height: 11px; font-size: 10ps">${ tlOtherExtendsInfo.isdanger == 1 ? '是' : '否'}</td>
							<!-- <td colspan="9"  style="width:330px;height:11px;font-size:10ps " >aaaa</td> -->
						</tr>
						<tr>
							<td colspan="11"
								style="width: 380px; height: 11px; font-size: 10ps">危险性描述（9）</td>
							<td colspan="11"
								style="width: 69px; height: 11px; font-size: 10ps">
								${tlOtherExtendsInfo.dangerDescription}</td>
						</tr>
						<tr>
							<td colspan="11"
								style="width: 380px; height: 11px; font-size: 10ps">安全措施说明（9）（10）</td>
							<td colspan="11"
								style="width: 69px; height: 11px; font-size: 10ps">
								${tlOtherExtendsInfo.safeExplain}</td>
						</tr>
						<tr>
							<td colspan="11"
								style="width: 380px; height: 10px; font-size: 10ps">是否需要在场地内摄像或摄影？</td>
							<td colspan="11"
								style="width: 69px; height: 10px; font-size: 10ps">${ tlOtherExtendsInfo.iscamera == 1 ? '是' : '否'}</td>
							<!-- <td colspan="9"  style="width:330px;height:10px;font-size:10ps " >aaaa</td> -->
						</tr>
						<tr>
							<td colspan="28"
								style="width: 985px; height: 10px; font-size: 10ps">设施预定</td>
						</tr>
						<tr>
							<!-- <td  style="width:35px;height:13px;font-size:10ps " >      </td> -->
							<td colspan="3"
								style="width: 104px; height: 13px; font-size: 10ps">${ tlOtherExtendsInfo.publicWorkshop == 1 ? '公共车间' : '无'}</td>
							<td colspan="3"
								style="width: 104px; height: 13px; font-size: 10ps">${ tlOtherExtendsInfo.confidentialWorkshop == 1 ? '保密车间' : '无'}</td>
							<td colspan="3"
								style="width: 104px; height: 13px; font-size: 10ps">${ tlOtherExtendsInfo.meetingRoom == 1 ? '会议室' : '无'}
							</td>
						</tr>
						<tr>
							<td colspan="11"
								style="width: 380px; height: 11px; font-size: 10ps">具体要求</td>
							<td colspan="11"
								style="width: 69px; height: 11px; font-size: 10ps">${tlOtherExtendsInfo.specificRequirement}</td>
						</tr>
						<tr rolspan="2">
							<td colspan="28"
								style="width: 985px; height: 10px; font-size: 10ps">其他服务预订</td>
						</tr>
						<tr>
							<td colspan="8"
								style="width: 276px; height: 10px; font-size: 10ps">
								是否需要租车服务？</td>
							<td style="width: 35px; height: 10px; font-size: 10ps">${ tlOtherExtendsInfo.isCarRentalService == 1 ? '是' : '否'}</td>
							<td rowspan="2"
								style="width: 35px; height: 20px; font-size: 10ps">aa</td>
							<td colspan="15" rowspan="2"
								style="width: 537px; height: 20px; font-size: 10ps">aaa</td>
						</tr>
						<tr>
							<td colspan="8"
								style="width: 276px; height: 10px; font-size: 10ps">是否需要租用试验驾驶员？</td>
							<td style="width: 35px; height: 10px; font-size: 10ps">${ tlOtherExtendsInfo.isNeedHireTestDriver == 1 ? '是' : '否'}</td>
						</tr>
						<tr>
							<td colspan="8"
								style="width: 138px; height: 12px; font-size: 10ps">其他特殊服务（11）</td>
							<td colspan="8"
								style="width: 847px; height: 12px; font-size: 10ps">
								${tlOtherExtendsInfo.otherSpecialServices}</td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 985px; height: 9px; font-size: 10ps">（*）为必填项</td>
						</tr>
						<tr>
							<td colspan="28" rowspan="12"
								style="width: 985px; height: 113px; font-size: 10ps">
								${tlOtherExtendsInfo.remarks}</td>
						</tr>


					</tbody>
				</table>
			</div>

			<div id="tabs-0"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-0" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<tbody>
						<tr>
							<td colspan="5"
								style="width: 173px; height: 10px; font-size: 10ps">订单号：</td>
							<td colspan="9"
								style="width: 311px; height: 10px; font-size: 10ps"></td>
							<td colspan="7"
								style="width: 213px; height: 10px; font-size: 10ps">客户编号：</td>
							<td colspan="7"
								style="width: 392px; height: 10px; font-size: 10ps"></td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 16px; font-size: 10ps">试验测试申请表</td>
						</tr>
						<!-- *******************************************客户基本信息（*）*************************************************** -->
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">客户基本信息（*）</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">公司名称</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">
								${tlCustomBaseinfo.companyName}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">地址</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.address}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">部门</td>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.department}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.telephone}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">邮编</td>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.zipCode}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">传真</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.fax}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">项目负责人</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">${tlCustomBaseinfo.userAuthorizer.name}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">联系电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">
								${tlCustomBaseinfo.contactNumberL}</td>
						</tr>
						<tr>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">邮箱</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.emailL}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">项目联系人（1）</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">
								${tlCustomBaseinfo.userLeader.name}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">联系电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.contactNumberC}</td>
						</tr>
						<tr>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">邮箱</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlCustomBaseinfo.emailC}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="tabs-4"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-4" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<tbody>
						<!-- ******************************************财务信息（*）***********************************************  -->
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">财务信息（*）</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">发票抬头</td>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">${tlFinanceInfo.invoiceRise}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">增值税号</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlFinanceInfo.vatNumber}</td>
						</tr>
						<tr>
							<td colspan="7" rowspan="2"
								style="width: 242px; height: 20px; font-size: 10ps">发票接收人</td>
							<td colspan="6" rowspan="2"
								style="width: 207px; height: 20px; font-size: 10ps">${tlFinanceInfo.invoiceReceiver}</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">联系电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlFinanceInfo.telInvRecever}</td>
						</tr>
						<tr>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">邮箱</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlFinanceInfo.email}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">开户银行名称</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">${tlFinanceInfo.bankName}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">开户行账号</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">${tlFinanceInfo.accountBank}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">公司注册地址</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">${tlFinanceInfo.registeredAddress}</td>
						</tr>
						<tr>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">发票接收地址</td>
							<td colspan="21"
								style="width: 847px; height: 10px; font-size: 10ps">${tlFinanceInfo.invoiceReceiveAddress}</td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">车辆及材料等寄送到试验场的地址</td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">（车辆和材料只在周一到周五的8:30-17:00卸货）</td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">寄送地址：安徽省滁州市定远县西卅店镇新建村定炉路XX号</td>
						</tr>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">邮编：233273
								联系电话：+86 18931648667</td>
						</tr>
						<tr>
							<td colspan="14"
								style="width: 483px; height: 10px; font-size: 10ps">寄件人</td>
							<td colspan="14"
								style="width: 605px; height: 10px; font-size: 10ps">收件人</td>
						</tr>
						<tr>
							<td colspan="2"
								style="width: 69px; height: 10px; font-size: 10ps">姓名</td>
							<td colspan="12"
								style="width: 414px; height: 10px; font-size: 10ps">
								${tlSendAddress.senderName}</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">姓名</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlSendAddress.receiverName}</td>
						</tr>
						<tr>
							<td colspan="2"
								style="width: 69px; height: 10px; font-size: 10ps">公司</td>
							<td colspan="12"
								style="width: 414px; height: 10px; font-size: 10ps">${tlSendAddress.senderCompany}
							</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">公司</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">
								${tlSendAddress.receiverCompany}</td>
						</tr>
						<tr>
							<td colspan="2"
								style="width: 69px; height: 10px; font-size: 10ps">电话</td>
							<td colspan="12"
								style="width: 414px; height: 10px; font-size: 10ps">${tlSendAddress.telSender}
							</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">电话</td>
							<td colspan="11"
								style="width: 502px; height: 10px; font-size: 10ps">${tlSendAddress.telReceiver}</td>
						</tr>
						<tr>
							<td colspan="14"
								style="width: 483px; height: 10px; font-size: 10ps">试验场客户助理姓名</td>
							<td colspan="14"
								style="width: 605px; height: 10px; font-size: 10ps">${tlSendAddress.assistantName}</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div id="tabs-3"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-3" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<tbody>
						<tr>
							<td colspan="28"
								style="width: 966px; height: 10px; font-size: 10ps">共享测试道路预定（*）</td>
						</tr>
						<tr>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">测试开始日期</td>
							<td colspan="8"
								style="width: 276px; height: 10px; font-size: 10ps"></td>
							<td colspan="8"
								style="width: 276px; height: 10px; font-size: 10ps">测试结束日期</td>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps"></td>
						</tr>
						<tr>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">测试道路</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">总车时数</td>
							<td colspan="13"
								style="width: 449px; height: 10px; font-size: 10ps">测试简要描述（8）（9）</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">最高测试车速</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">同时测试车辆数量</td>
						</tr>
						<c:forEach items="${listTC}" var="tlTestprojectChild"
							varStatus="status">
							<tr>
								<td colspan="6"
									style="width: 207px; height: 13px; font-size: 10ps">
									${fns:getDictLabel(tlTestprojectChild.testRoad, 'test_road', '')}
								</td>
								<td colspan="3"
									style="width: 104px; height: 13px; font-size: 10ps">
									${tlTestprojectChild.carTime}</td>
								<td colspan="13"
									style="width: 449px; height: 13px; font-size: 10ps">
									${tlTestprojectChild.briefDescription}</td>
								<td colspan="3"
									style="width: 104px; height: 13px; font-size: 10ps">
									${tlTestprojectChild.limitSpeed}</td>
								<td colspan="3"
									style="width: 104px; height: 13px; font-size: 10ps">
									${tlTestprojectChild.carLimNum}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="28"
								style="width: 985px; height: 10px; font-size: 10ps">测试包场预定</td>
						</tr>
						<tr>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">测试道路</td>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">包场日期</td>
							<td colspan="7"
								style="width: 242px; height: 10px; font-size: 10ps">包场时间</td>
							<td colspan="9"
								style="width: 330px; height: 10px; font-size: 10ps">同时使用场地车辆数目</td>
						</tr>
						<c:forEach items="${listTest}" var="tlTestRoomReservationChild"
							varStatus="status">
							<tr>
								<td colspan="6"
									style="width: 207px; height: 13px; font-size: 10ps">
									${fns:getDictLabel(tlTestRoomReservationChild.testRoad, 'test_road', '')}
								</td>
								<td colspan="6"
									style="width: 207px; height: 13px; font-size: 10ps"><fmt:formatDate
										value="${tlTestRoomReservationChild.packageDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td colspan="7"
									style="width: 242px; height: 13px; font-size: 10ps">
									${tlTestRoomReservationChild.packageTime}</td>
								<td colspan="9"
									style="width: 330px; height: 13px; font-size: 10ps">
									${tlTestRoomReservationChild.carLimNum}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<div id="tabs-2"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-2" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<therd>
						<tr>
							<td colspan="28"
								style="width: 966px; height: 10px; font-size: 10ps">车辆信息（*）</td>
						</tr>
						<tr>
							<td style="width: 35px; height: 10px; font-size: 10ps">序号</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">类别（7）</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">类型</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">>3.5t</td>
							<td colspan="5"
								style="width: 173px; height: 10px; font-size: 10ps">燃料类型</td>
							<td colspan="4"
								style="width: 138px; height: 10px; font-size: 10ps">颜色/牌照</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">品牌型号</td>
							<td colspan="3"
								style="width: 104px; height: 10px; font-size: 10ps">最高车速</td>
							<td colspan="2"
								style="width: 69px; height: 10px; font-size: 10ps">VIN后6位</td>
						</tr>
						</therd>
						<tbody>
						<c:forEach items="${listCarInfo}" var="tlCarInfo"
							varStatus="status">
							<tr>
								<td rowspan="2"
									style="width: 35px; height: 22px; font-size: 10ps">${ status.index + 1}</td>
								<td colspan="3" rowspan="2"
									style="width: 104px; height: 22px; font-size: 10ps">${fns:getDictLabel(tlCarInfo.carType, 'car_type', '')}</td>
								<td colspan="3" rowspan="2"
									style="width: 104px; height: 11px; font-size: 10ps">${fns:getDictLabel(tlCarInfo.loadType, 'load_type', '')}</td>
								<td colspan="2"
									style="width: 69px; height: 11px; font-size: 10ps">车重：</td>
								<td colspan="2"
									style="width: 69px; height: 11px; font-size: 10ps">${tlCarInfo.carWeight}</td>
								<td colspan="5"
									style="width: 173px; height: 11px; font-size: 10ps">${fns:getDictLabel(tlCarInfo.fuelType, 'fuel_type', '')}</td>
								<td colspan="4" rowspan="2"
									style="width: 138px; height: 22px; font-size: 10ps">${tlCarInfo.colorLicense}</td>
								<td colspan="3" rowspan="2"
									style="width: 104px; height: 22px; font-size: 10ps">${tlCarInfo.brandModel}</td>
								<td colspan="3" rowspan="2"
									style="width: 104px; height: 22px; font-size: 10ps">${tlCarInfo.limitSpeed}</td>
								<td colspan="2" rowspan="2"
									style="width: 69px; height: 22px; font-size: 10ps">${tlCarInfo.vinAfterSix}</td>
							</tr>
							<tr>
								<td colspan="2"
									style="width: 69px; height: 11px; font-size: 10ps">最大轴重：</td>
								<td colspan="2"
									style="width: 69px; height: 11px; font-size: 10ps">${tlCarInfo.maxAxleLoad}</td>
								<td colspan="2"
									style="width: 69px; height: 11px; font-size: 10ps">预计消耗量：</td>
								<td colspan="3"
									style="width: 104px; height: 11px; font-size: 10ps">${tlCarInfo.estimatedConsumption}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="tabs-1"
				class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"
				style="padding: 0em;">
				<table id="table-1" border="1" cellpadding="1" cellspacing="0" class="table table-striped table-bordered table-condensed"
					style="width: 100%;">
					<thead>
						<tr>
							<td colspan="28"
								style="width: 1088px; height: 10px; font-size: 10ps">到访人员信息登记（*）</td>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td colspan="3"
								style="width: 104px; height: 20px; font-size: 10ps">姓名</td>
							<td colspan="7"
								style="width: 242px; height: 20px; font-size: 10ps">身份证/护照（2）</td>
							<td colspan="5"
								style="width: 173px; height: 20px; font-size: 10ps">是否为试验驾驶员（3）</td>
							<td colspan="6"
								style="width: 179px; height: 20px; font-size: 10ps">是否申请试验场驾驶许可证（4）</td>
							<td colspan="3"
								style="width: 197px; height: 20px; font-size: 10ps">是否参加安全简介培训</td>
							<td colspan="4"
								style="width: 195px; height: 20px; font-size: 10ps">是否入住试验场酒店（5）（6）</td>
						</tr>
						<c:forEach items="${listVistor}" var="tlVistorRegister">
							<tr>
								<td colspan="3"
									style="width: 104px; height: 10px; font-size: 10ps">
									${tlVistorRegister.name}</td>
								<td colspan="7"
									style="width: 242px; height: 10px; font-size: 10ps">
									${tlVistorRegister.idcardPassport}</td>
								<td colspan="5"
									style="width: 173px; height: 10px; font-size: 10ps">
									${tlVistorRegister.driver == 1 ?'是':'否'}</td>
								<td colspan="6"
									style="width: 179px; height: 10px; font-size: 10ps">
									${tlVistorRegister.applyLicense == 1 ?'是':'否'}</td>
								<td colspan="3"
									style="width: 197px; height: 10px; font-size: 10ps">
									${tlVistorRegister.joinSafetrain == 1 ?'是':'否'}</td>
								<td colspan="4"
									style="width: 195px; height: 10px; font-size: 10ps">
									${tlVistorRegister.checkinHotel == 1 ?'是':'否'}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="28"
								style="width: 1097px; height: 11px; font-size: 10ps">试验场酒店（中汽研酒店）预定（5）（6）</td>
						</tr>
						<tr>
							<td colspan="6"
								style="width: 207px; height: 10px; font-size: 10ps">房间类型</td>
							<td colspan="5"
								style="width: 173px; height: 10px; font-size: 10ps">预定数量</td>
							<td colspan="7"
								style="width: 250px; height: 10px; font-size: 10ps">入住日期</td>
							<td colspan="10"
								style="width: 467px; height: 10px; font-size: 10ps">退房日期</td>
						</tr>

						<c:forEach items="${listHotel}" var="tlTestSiteHotel">
							<tr>
								<td colspan="6"
									style="width: 207px; height: 11px; font-size: 10ps">
									${fns:getDictLabel(tlTestSiteHotel.roomType, 'room_type', '')}
								</td>
								<td colspan="5"
									style="width: 173px; height: 11px; font-size: 10ps">${tlTestSiteHotel.reserveQuantity}</td>
								<td colspan="7"
									style="width: 250px; height: 11px; font-size: 10ps"><fmt:formatDate
										value="${tlTestSiteHotel.checkInDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td colspan="10"
									style="width: 467px; height: 11px; font-size: 10ps"><fmt:formatDate
										value="${tlTestSiteHotel.checkOutDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
		<act:histoicFlow procInsId="${tlCustomBaseinfo.procInsId}"/>
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