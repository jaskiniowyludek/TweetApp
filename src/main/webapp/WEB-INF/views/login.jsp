<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <form name='login' action="/login" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Send" /></td>
            </tr>
            <c:if test="${not empty errorMessage}">
                <div style="color:red; font-weight: bold; margin: 30px 0px;"><c:out value="${errorMessage}"/></div></c:if>

        </table>
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
