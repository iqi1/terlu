<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验测试申请表管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/jquery-ui/1.12.0/jquery-ui.min.css" type="text/css" rel="stylesheet" />	
	<link rel="stylesheet" href="${ctxStatic}/terlu/css/dataInput.css" media="screen" title="no title" charset="utf-8">
	<script src="${ctxStatic}/jquery-ui/1.12.0/jquery-ui.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/modules/tlCustomBaseinfo/list">试验测试申请表列表</a></li>
		<shiro:hasPermission name="modules:tlCustomBaseinfo:edit"><li><a href="${ctx}/modules/tlCustomBaseinfo/form">试验测试申请表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlCustomBaseinfo" action="${ctx}/modules/tlCustomBaseinfo/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>公司名称：</label>
				<form:input path="companyName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="telephone" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<%-- <li><label>项目负责人：</label>
				<form:input path="userAuthorizer.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>项目联系人：</label>
				<form:input path="userLeader.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>公司名称</th>
				<th>测试开始日期</th>
				<th>测试结束日期</th>
				<th>地址</th>
				<th>电话</th>
				<th>传真</th>
				<th>邮箱</th>
				<th>项目负责人</th>
				<th>项目负责人联系电话</th>
				<th>项目联系人</th>
				<th>项目联系人联系电话</th>
				<th>更新时间</th>
				<th>状态</th>
				<!--  <th>备注信息</th>-->
				<shiro:hasPermission name="modules:tlCustomBaseinfo:view"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlCustomBaseinfo">
			<tr>
				<td>
				<!--  <a href="${ctx}/modules/tlCustomBaseinfo/formBaseInfo?id=${tlCustomBaseinfo.id}">基本信息</a>-->
    				<a href="javascript:void(0)" class="checkedTest">${tlCustomBaseinfo.companyName}</a>&nbsp;&nbsp;
    				<div class="detection">
							<ul>
							<c:if test="${empty tlCustomBaseinfo.procInsId || tlCustomBaseinfo.procName == '修改'}"> 
								<li>
									<a  href="${ctx}/modules/tlTestprojectChild/list?tlTestprojectId=${tlCustomBaseinfo.id}"  id="o_report">测试项目</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlVistorRegister/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">到访人员</a>
								</li>
								<li>
									<%-- <a onclick="addFieldTest('${tlCustomBaseinfo.id}')" >测试包场</a> --%>
									<a  href="${ctx}/modules/tlTestRoomReservationChild/list?tlCustomBaseinfoId=${tlCustomBaseinfo.id}"  id="o_report">测试包场</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlCarInfo/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">车辆登记</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlTestSiteHotel/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">酒店预定</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlOtherExtendsInfo/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">其他信息</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlFinanceInfo/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">财务信息</a>
								</li>
								<li>
									<a  href="${ctx}/modules/tlSendAddress/list?parentId=${tlCustomBaseinfo.id}"  id="o_report">寄送地址</a>
								</li>
								</c:if>
							</ul>
						</div>
					</td>
				<!-- 测试开始日期 -->
				<td>
					<fmt:formatDate value="${tlCustomBaseinfo.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<!-- 测试结束日期 -->
				<td>
					<fmt:formatDate value="${tlCustomBaseinfo.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlCustomBaseinfo.address}
				</td>
				<td>
					${tlCustomBaseinfo.telephone}
				</td>
				<td>
					${tlCustomBaseinfo.fax}
				</td>
				<td>
					${tlCustomBaseinfo.email}
				</td>
				<td>
					${tlCustomBaseinfo.userAuthorizer.name}
				</td>
				<td>
					${tlCustomBaseinfo.contactNumberL}
				</td>
				<td>
					${tlCustomBaseinfo.userLeader.name}
				</td>
				<td>
					${tlCustomBaseinfo.contactNumberC}
				</td>
				<td>
					<fmt:formatDate value="${tlCustomBaseinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${not empty tlCustomBaseinfo.procInsId ?'已经提交':'没提交'}
					<c:if test="${not empty tlCustomBaseinfo.procInsId}"> 
					 ${empty tlCustomBaseinfo.procName ? ' 通过审核':tlCustomBaseinfo.procName}
					</c:if>
				</td>
				<!--  <td>
					${tlCustomBaseinfo.remarks}
				</td>-->
				<td><shiro:hasPermission name="modules:tlCustomBaseinfo:audit">
	
				<a href="${ctx}/modules/tlCustomBaseinfo/formAudit?id=${tlCustomBaseinfo.id}&status=${tlCustomBaseinfo.status}">详情</a>
				</shiro:hasPermission>
				<a href="${ctx}/modules/tlCustomBaseinfo/showReport?id=${tlCustomBaseinfo.id}#toolbar=0">报表</a>
				
				<shiro:hasPermission name="modules:tlCustomBaseinfo:edit">
				<c:if test="${empty tlCustomBaseinfo.procInsId || tlCustomBaseinfo.procName == '修改'}"> 
    				<a href="${ctx}/modules/tlCustomBaseinfo/form?id=${tlCustomBaseinfo.id}">修改</a>
				</c:if>
				<c:if test="${empty tlCustomBaseinfo.procInsId}">
					<a href="${ctx}/modules/tlCustomBaseinfo/delete?id=${tlCustomBaseinfo.id}" onclick="return confirmx('确认要删除该试验测试申请表吗？', this.href)">删除</a>
				</c:if>
				</shiro:hasPermission></td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	
	<script type="text/javascript">
			// 检测
		$(function(){
	      var $checkedTest = $(".checkedTest");
				var $detection = $(".detection");
				//console.log($detection);
				var isShow = false;
				$checkedTest.on("click",function(){
				  var index =$checkedTest.index(this);
	        $detection.eq(index).css('display','block')
				});
				$detection.on("mouseover",function(){
				  isShow = true;
					$(this).show();
				});
				$detection.mouseout(function(){
						if(isShow)
						{
								$(this).hide();
								isShow=false;
						}
				});
		})
			
		function addCarTest(id){
			console.info(id);	
	//onclick="addCarTest('${tlCustomBaseinfo.id}')"
		}
			
		function addFieldTest(id){
			console.info(id);	
	
		}
	</script>
</body>
</html>