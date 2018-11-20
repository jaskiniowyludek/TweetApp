<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 19/11/18
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your messages</title>
</head>
<body>
    <%@include file="fragments/header2.jsp"%>
    <h2>Messages you received:</h2>
    <c:forEach items="${received}" var="msg">
        <c:set var = "wholeM" value = "${msg.text}"/>
        <c:set var = "partM" value = "${fn:substring(wholeM, 0, 30)}" />
        <p>Title: ${msg.title}</p>
        <p>Author: ${msg.sender.username}</p>
        <p>Sent on: ${msg.date}</p>
        <p>Message: ${partM}...<a href="/showmsg?id=${msg.id}">Read message</a> </p>
    <c:set var = "seen" value = "${msg.readed}"/>
    <c:choose>
        <c:when test = "${seen == true}">
    <p>Message seen<p>
        </c:when>
        <c:when test = "${seen == false}">
    <p>Message unread<p>
        </c:when>
    </c:choose>
    </c:forEach>
    <h2>The messages you sent:</h2>
    <c:forEach items="${sent}" var="msgs">
        <c:set var = "wholeM" value = "${msgs.text}"/>
        <c:set var = "partM" value = "${fn:substring(wholeM, 0, 30)}" />
        <p>Title: ${msgs.title}</p>
        <p>Author: ${msgs.sender.username}</p>
        <p>Sent on: ${msgs.date}</p>
        <p>Message: ${partM}...<a href="/showyourmsg?id=${msgs.id}">Read message</a></p>
    <c:set var = "seen" value = "${msgs.readed}"/>
    <c:choose>
    <c:when test = "${seen == true}">
    <p>Message seen by ${msgs.receiver.username}<p>
        </c:when>
        <c:when test = "${seen == false}">
    <p>Message unread<p>
        </c:when>
        </c:choose>
    </c:forEach>

</body>
</html>
