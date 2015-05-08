<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>


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
                <c:out value="${item.publishedDate}"/>
                <br/>
                <b><i><c:out value="${item.blog.name}"/></i></b>
            </td>
            <td>
                <strong>
                    <a href='<c:out value="${item.link}" />' target="_blank">
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
