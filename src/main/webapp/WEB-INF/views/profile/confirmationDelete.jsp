<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 21/11/18
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<%@include file="../fragments/header2.jsp"%>
<h2>You are about to delete your user.</h2>
<form method="post" action="/deleteUser">
    <div>
        Please, type password to confirm:
        <input type="password" name="password">
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0px;"><c:out value="${errorMessage}"/></div></c:if>
        <input type="submit" value="Save">
    </div>
</body>
</html>
