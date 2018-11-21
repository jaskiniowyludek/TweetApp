<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 20/11/18
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your profile</title>
</head>
<body>
<%@include file="fragments/header2.jsp"%>
<c:if test="${not empty errorMessage}">
    <div style="color:green; font-weight: bold; margin: 30px 0px;"><c:out value="${errorMessage}"/></div></c:if>
   <p>Username: ${currentUser.username}
       <a href="/changeUsername">Change username</a></p>
    <p>Email: ${currentUser.email}
        <a href="/changeEmail">Change email address</a></p>
    <div><a href="/changePassword">Change password</a> </div>
    <div><p><a href="/deleteUser?userId=${currentUser.id}"> Delete your account</a></p></div>
</body>
</html>
