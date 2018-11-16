<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 16/11/18
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <%@include file="fragments/header.jsp"%>
    <form method="post" action="#">
        <div>
            Username:
           <input type="text" name="username" placeholder="Type login">
        </div>
        <div>
            Password:
            <input type="password" name="password" placeholder="Type password">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>
</body>
</html>
<%--Strona	ma	przyjmować	email	użytkownika	i	jego--%>
<%--hasło.--%>
<%--jeżeli	są	poprawne,	to	użytkownik	jest--%>
<%--przekierowany	do	strony	głównej,--%>
<%--jeżeli	nie	–	do	strony	logowania,	która	ma--%>
<%--wtedy	wyświetlić	komunikat	o	błędnym--%>
<%--loginie	lub	haśle,--%>
<%--strona	logowania	ma	mieć	też	link	do	strony--%>
<%--tworzenia	użytkownika.--%>
