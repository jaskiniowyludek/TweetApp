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
<ul>
    <li>
    <li><p>
        ${tweet.text}
    </p>
        Added by: <a href="/showUser?id=${tweet.user.id}">${tweet.user.username}</a> on ${tweet.date}
    </li>
</ul>

</body>
</html>
