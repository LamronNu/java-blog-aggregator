<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<%--menu--%>
<tilesx:useAttribute name="current"/>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${current == 'index' ? 'active':''}">
                        <a href='<spring:url value="/"/>'>Home</a></li>

                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="${current == 'users' ? 'active' : ''}">
                            <a href="<spring:url value="/users.html" />">Users</a></li>
                    </security:authorize>

                    <li class="${current == 'register' ? 'active':''}">
                        <a href='<spring:url value="/register.html"/>'>Register</a></li>
                    <security:authorize access="!isAuthenticated()">

                        <li class="${current == 'login' ? 'active':''}">
                            <a href='<spring:url value="/login.html"/>'>Login</a></li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li class="${current == 'account' ? 'active':''}">
                            <a href='<spring:url value="/account.html"/>'>My account</a></li>
                        <li><a href='<spring:url value="/logout"/>'>Logout</a></li>
                    </security:authorize>

                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
    <%--body--%>
    <tiles:insertAttribute name="body"/>
    <br>
    <%--footer--%>
    <div style="text-align: center;"><tiles:insertAttribute name="footer"/></div>
</div>

</body>
</html>