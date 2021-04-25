<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试验项目管理管理</title>
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
		<li class="active"><a href="${ctx}/modules/tlTestprojectChild/list?tlTestprojectId=${tlTestprojectChild.tlTestprojectId}">试验项目管理列表</a></li>
		<shiro:hasPermission name="modules:tlTestprojectChild:edit"><li><a href="${ctx}/modules/tlTestprojectChild/form?tlTestprojectId=${tlTestprojectChild.tlTestprojectId}">试验项目管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tlTestprojectChild" action="${ctx}/modules/tlTestprojectChild/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>测试道路：</label>
				<form:select path="testRoad" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>测试道路</th>
				<th>总车时数</th>
				<th>测试简要描述</th>
				<th>最高测试车速</th>
				<th>同时测试车辆数量</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="modules:tlTestprojectChild:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tlTestprojectChild">
			<tr>
				<td><a href="javascript:void(0)" class="checkedTest">
					${fns:getDictLabel(tlTestprojectChild.testRoad, 'test_road', '')}
				</a>
				<div class="detection">
					<ul>
						<li>
							<a href="${ctx}/modules/tlTestTaskList/list?projectId=${tlTestprojectChild.id}" id="o_report">分配任务</a>
						</li>
						<%-- <li>
							<a href="${ctx}/modules/tlFuelManage/list?project=${tlTestprojectChild.id}" id="o_report">加油申请</a>
						</li> --%>
					</ul>
				</div></td>
				<td>
					${tlTestprojectChild.carTime}
				</td>
				<td>
					${tlTestprojectChild.briefDescription}
				</td>
				<td>
					${tlTestprojectChild.limitSpeed}
				</td>
				<td>
					${tlTestprojectChild.carLimNum}
				</td>
				<td>
					<fmt:formatDate value="${tlTestprojectChild.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tlTestprojectChild.remarks}
				</td>
				<shiro:hasPermission name="modules:tlTestprojectChild:edit"><td>
    				<a href="${ctx}/modules/tlTestprojectChild/form?id=${tlTestprojectChild.id}">修改</a>
					<a href="${ctx}/modules/tlTestprojectChild/delete?id=${tlTestprojectChild.id}" onclick="return confirmx('确认要删除该试验项目管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
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
			
	</script>
</body>
</html>