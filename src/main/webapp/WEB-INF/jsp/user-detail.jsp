<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach items="${user.blogs}" var="blog">
    <h2> ${blog.name}</h2>

    <p> ${blog.url}</p>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blog.items}" var="item">
            <tr>
                <th>${item.title}</th>
                <th>${item.link}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>
