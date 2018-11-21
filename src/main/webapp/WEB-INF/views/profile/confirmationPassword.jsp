<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 21/11/18
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>
</head>
<body>
<%@include file="../fragments/header2.jsp"%>
<h2>You are about to change your password.</h2>
<form:form method="post" action="/changePassword">
    <div>
      <p> Please, type your new password:
        <input type="password" name="newPassword"></p>
       <p> Please, type your new password again to confirm it:
        <input type="password" name="newPassword2"></p>
       <p> Please, type password to confirm:
        <input type="password" name="password"></p>
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0px;"><c:out value="${errorMessage}"/></div></c:if>
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>
