<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 19/11/18
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New message</title>
</head>
<body>
<%@include file="fragments/header2.jsp"%>
<c:if test="${not empty confirmation}">
    <p style="color:black; font-weight: bold; margin: 30px 0px;"><c:out value="${confirmation}"/></p></c:if>
    <p>New message: </p>
    <form:form method="post" modelAttribute="message">
        <div>Title:
            <form:input path="title" placeholder="Type title"/>
            <form:errors path="title"/></div>
        <div>Message:
            <form:textarea path="text" placeholder="Type your message here"/>
            <form:errors path="text"/>
        </div>
        <form:hidden path="receiver.id" value="${userReceiver.id}"/>
        <form:errors path="receiver"/>
        <%--<input type="hidden" name="userReceiver" value="${userReceiver.id}">--%>
        <input type="submit" value="Send">
    </form:form>

</body>
</html>
