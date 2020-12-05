<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bank application</title>
</head>

<body>
    <h1>Welcome to the best bank application!</h1>
    <P>Time on server: ${serverTime}</P>
    <P>Your IP address: ${ipAddress}</P>

<form action="adminPanel" method="get">
    <input type="submit" value="Admin panel">
</form>

    <form action="clientPanel" method="get">
    <input type="submit" value="Client panel">
</form>

</body>
</html>