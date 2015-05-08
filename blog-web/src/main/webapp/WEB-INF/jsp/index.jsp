
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<h1>Latest news from the Java world:</h1>

<%--pages and sort--%>
<c:set var="previousPage" scope="session" value="${currentPage == 1 ? 1 : currentPage - 1}"/>
<c:set var="nextPage" scope="session" value="${currentPage == pages ? pages : currentPage + 1}"/>


<nav>
    <ul class="pagination navbar-right pagination pagination-sm">
        <li>
            <a href='<spring:url value="/page/${previousPage}.html"/>' aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var = "page" begin="1" end="${pages}">
            <li class="${currentPage == page ? 'active':''}">
                <a href='<spring:url value="/page/${page}.html"/>'>
                    <c:out value="${page}"/></a></li>
        </c:forEach>
        <li>
            <a href='<spring:url value="/page/${nextPage}.html"/>' aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<%--items table--%>
<table class="table table-bordered table-hover table-striped" id="itemsTable">
    <thead>
    <tr>
        <th>#</th>
        <th>date</th>
        <th>item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item" varStatus="rowCounter">
        <tr>
            <td align="center">
                <c:set var="rowNumber" scope="session" value="${(currentPage - 1) * pageSize + rowCounter.count}"/>
                <b><c:out value="${rowNumber}"/></b>
            </td>
            <td>
                <fmt:formatDate value="${item.publishedDate}" pattern="dd-MM-yyyy"/>
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
