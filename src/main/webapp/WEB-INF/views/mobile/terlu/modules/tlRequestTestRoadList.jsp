<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<section id="modules_tlRequestTestRoad" data-transition="slideUp">
    <header>
        <nav class="left">
            <a href="#" data-icon="undo" data-target="back">返回</a>
        </nav>
        <h1 class="title">list</h1>
    </header>

    <article class="active" id="list_article"  data-scroll="true">
        <ul class="list">
 		<c:forEach items="${page.list}" var="tlRequestTestRoad">
            <li data-icon="next" data-selected="selected">
           		<a href="#modules_tlRequestTestRoad_form?projectId=${tlRequestTestRoad.projectId}&startTime=<fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&testRoad=${tlRequestTestRoad.testRoad}" 
           		data-target="section">
                <div class="tag"><fmt:formatDate value="${tlRequestTestRoad.startTime}" pattern="yyyy-MM-dd"/></div>
                <strong>${tlRequestTestRoad.projectName}</strong>
                <p>${fns:getDictLabel(tlRequestTestRoad.testRoad, 'test_road', '')}</p>
                <p><span class="label">车辆数量</span><span class="label">${tlRequestTestRoad.carCount}</span></p>
                </a>
            </li>
        </c:forEach>
        </ul>
    </article>

</section>
