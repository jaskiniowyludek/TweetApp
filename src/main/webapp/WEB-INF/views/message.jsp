<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 20/11/18
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<%@include file="fragments/header2.jsp"%>
<p>Title: ${message.title}</p>
<p>Author: ${message.sender.username}</p>
<p>Sent on: ${message.date}</p>
<p>Message: ${message.text}</p>
</body>
</html>
