<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Hello from spring web mvc!
<br>

<%@ include file="../layout/taglib.jsp" %>

<h1>Latest news from the Java world:</h1>

<%--pages and sort--%>
<c:set var="previousPage" scope="session" value="${currentPage == 1 ? 1 : currentPage}"/>

<nav>
    <ul class="pagination navbar-right">
        <li>
            <a href="index/pages/${previousPage}.html" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var = "page" begin="1" end="${pages}">
            <li><a href="<spring:url value='pages/${page}.html'/>">${page}</a></li>
        </c:forEach>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
    <%--<ul class="nav nav-tabs navbar-right">--%>
        <%--<ul class="nav nav-tabs">--%>
            <%--<li role="presentation" class="active"><a href="#">1</a></li>--%>
            <%--<c:choose>--%>
                <%--<c:when test="${pages == 2}">--%>
                    <%--<li role="presentation" class="active"><a href="#">2</a></li>--%>
                <%--</c:when>--%>
                <%--<c:when test="${pages == 3}">--%>
                    <%--<li role="presentation"><a href="#">2</a></li>--%>
                    <%--<li role="presentation"><a href="#">3</a></li>--%>
                <%--</c:when>--%>

                <%--<c:otherwise>--%>
                    <%--<li role="presentation">...</li>--%>
                    <%--<li role="presentation"><a href="#">${pages}</a></li>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>


            <%--&lt;%&ndash;to do sort&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li role="presentation" class="dropdown">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">&ndash;%&gt;--%>
            <%--&lt;%&ndash;Dropdown <span class="caret"></span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="dropdown-menu" role="menu">&ndash;%&gt;--%>
            <%--&lt;%&ndash;...&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
        <%--</ul>--%>
    <%--</ul>--%>


<%--items table--%>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>date</th>
        <th>item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>
                <c:out value="${item.publishedDate}"/>
                <br/>
                <b><i><c:out value="${item.blog.name}"/></i></b>
            </td>
            <td>
                <strong>
                    <a href="<c:out value="${item.link}" />" target="_blank">
                        <c:out value="${item.title}"/>
                    </a>
                </strong>
                <br/>
                    ${item.description}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
