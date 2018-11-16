<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 16/11/18
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register as a new user</title>
</head>
<body>
    <%@include file="fragments/header.jsp"%>
</body>
</html>
<%--Strona ma pobierać email i haslo--%>
<%--Jeżeli	takiego	adresu	email	nie	ma	jeszcze	w--%>
<%--systemie	(tabeli	w	bazie),	to	rejestrujemy--%>
<%--użytkownika	i	logujemy	(przekierowanie	na--%>
<%--stronę	główną).--%>
<%--Jeżeli	taki	adres	email	jest,	to--%>
<%--przekierowujemy	do	strony	tworzenia--%>
<%--użytkownika	(ta	sama	strona)	i	wyświetlamy--%>
<%--komunikat	o	zajętym	adresie	email.--%>