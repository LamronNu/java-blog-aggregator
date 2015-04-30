<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp" %>

<link href="signin.css" rel="stylesheet">

<div class="container">
    <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check" />" method="POST">
        <h2 class="form-signin-heading">Please, sign in</h2>
        <input type="text" name="j_username" class="form-control" placeholder="Name" required autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <br>
        <br>

        <div>you can log in as admin/admin or user/user</div>
    </form>

</div>
