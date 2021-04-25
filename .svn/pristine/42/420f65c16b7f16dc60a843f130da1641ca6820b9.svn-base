<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<section id="modules_tlRequestTestRoad_form" >
    <header>
        <nav class="left">
            <a href="#" data-icon="previous" data-target="back">Back</a>
        </nav>
        <h1 class="title">aaa</h1>
    </header>

    <footer>
        <a href="#v_scroll_article" class="active" data-target="article" data-icon="arrow-up-2">纵向滚动</a>
        <a href="#h_scroll_article" data-target="article" data-icon="arrow-left-2">横向滚动</a>
    </footer>
    <article data-scroll="true" class="active " id="v_scroll_article" >
        
        <div class="indented">
            <!-- Input -->
            <form id="inputForm" class="form-horizontal" action="/terlu/a/modules/tlRequestTestRoad/save" method="post" novalidate="novalidate">
            <input id="id" name="id" type=hidden value="${tlRequestTestRoad.id}"/>
            <input id="selects" name="selects" type=hidden value="${tlRequestTestRoad.selects}"/>
            <div class="input-row">
            <table>
            <tr>
            <th>
           	<label class="control-label">日期：</label>
            </th>
            <th><input type="date" name="startTime" value="<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd"/>" >
            </th>
            <th><input type="time" value="08:00">
            </th>
            </tr>
            </table>
			</div>
			
			<div class="input-row">

            <div class="control-group">
			<label class="control-label">测试道路：</label>
			<div class="controls">
				<form:select path="tlRequestTestRoad.testRoad" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('test_road')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			</div>
			</div>
			<div class="input-row">
		<div class="control-group">
			<label class="control-label">项目：</label>
			<div class="controls">
				<form:select path="tlRequestTestRoad.projectId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${list}" itemLabel="companyName" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
			</div>

                <div class="input-row">
                <div id="roads" ></div>
                </div>

                <shiro:hasPermission name="modules:tlRequestTestRoad:edit">
                <a class="button block" href="#" id="btn_t_bottom" onclick="saveData()" data-icon="cogs" data-target="back">保存</a>
                &nbsp;</shiro:hasPermission>
            </form>
        </div>
    </article>
    
    <article id="h_scroll_article">
        <div style="margin:20px 10px;">
            <h1 style="margin:10px 0;">左右滑动试试</h1>
            <div style="overflow: hidden;" id="h_scroll_demo">
                <ul class="control-group" style="width: 700px; border-radius: 0px; transition-property: transform; transform-origin: 0px 0px; transform: translate(0px, 0px) scale(1) translateZ(0px);">
                    <li class="active"><a href="#">Hello</a></li>
                    <li><a href="#">Jingle</a></li>
                    <li><a href="#" >html5</a></li>
                    <li><a href="#" >html5</a></li>
                    <li><a href="#" >html5</a></li>
                    <li><a href="#" >html5</a></li>
                    <li><a href="#" >html5</a></li>
                </ul>
            </div>
        </div>
    </article>

    <script type="text/javascript">
   

    $( function() {
    	var id = $("#id").val();
    	console.log(id);
    	if(typeof(id) != "undefined"){
    		initTestRoadBox("null");
    		modify = true;
    	}
    		
    });
    </script>

</section>
