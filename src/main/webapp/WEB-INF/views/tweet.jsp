<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 19/11/18
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet's details</title>
</head>
<body>
<%@include file="fragments/header2.jsp"%>
    <p>
        ${tweet.text}
    </p>
        Added by: <a href="/showUser?id=${tweet.user.id}">${tweet.user.username}</a> on ${tweet.date}
    <p>
        Add new comment:
        <div>
    <form:form method="post" modelAttribute="newComment">
        <form:textarea path="text" placeholder="Type your comment"/>
        <form:errors path="text"/>
        <input type="hidden" name="tweetId" value="${tweet.id}">
        <input type="submit" value="Send"/>
    </form:form>
</div>
<p>All comments:</p>
        <c:forEach items="${comments}" var="comment">
        <p>
            ${comment.text}
        </p>
        Added by: ${comment.user.username} on ${comment.date}
        </c:forEach>

</body>
</html>
