<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 18/11/18
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's details</title>
</head>
<body>
<%@include file="fragments/header2.jsp"%>
<p><a href="/sendmsg?userId=${user.id}"> Send a message to this user</a></p>
<h2>See all ${user.username}'s tweets:</h2>
<ul>
    <c:forEach items="${tweets}" var="tweet">
        <li><p>
                ${tweet.text}
        </p>
            Added by: ${tweet.user.username} on ${tweet.date}
            </li>
        <p>
            <a href="/tweet?id=${tweet.id}">Details</a>
        </p>
    </c:forEach>
</ul>
<p><a href="/homepage">Back to the previous page</a> </p>
</body>
</html>
