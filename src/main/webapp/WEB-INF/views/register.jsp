<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 16/11/18
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register as a new user</title>
</head>
<body>
    <%@include file="fragments/header.jsp"%>
    <h2>Register as a new user</h2>
    <form:form method="post" modelAttribute="user">
        <div>
            Username:
            <form:input path="username" placeholder="Type username"/>
            <form:errors path="username"/>
        </div>
        <div>
            Email:
            <form:input path="email" placeholder="Type your email address"/>
            <form:errors path="email"/>
        </div>
        <div>
            Password:
            <form:password path="password" placeholder="Type password"/>
            <form:errors path="password"/>
        </div>
        <div><input type="submit" value="Send"></div>
    </form:form>
</body>
</html>
