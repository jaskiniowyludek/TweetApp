<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 16/11/18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to TweetApp!</title>
</head>
<body>
    <%@include file="fragments/header2.jsp"%>
        <h2>Add new tweet:</h2>
        <form:form method="post" modelAttribute="tweet">
            <form:textarea path="text" placeholder="Type your tweet"/>
            <form:errors path="text"/>
            <input type="submit" value="Send">
        </form:form>
    <div>
        <h2>The newest tweets:</h2>
    <ul>
        <c:forEach items="${tweets}" var="tweet">
            <li>Added by: <a href="/showUser?id=${tweet.user.id}">${tweet.user.username}</a> on ${tweet.date}
            <p>
                ${tweet.text}
            </p></li>
        </c:forEach>
    </ul>
    </div>
</body>
</html>
<%--//Strona	wyświetlająca	wszystkie	Tweety	jakie--%>
<%--znajdują	się	w	systemie	(	od	najnowszego	do--%>
<%--najstarszego).	Nad	nimi	ma	być	widoczny--%>
<%--formularz	do	stworzenia	nowego	wpisu.--%>