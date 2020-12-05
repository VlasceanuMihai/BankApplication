<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration confirmed</title>
</head>
<body>
<h3>Salut ${Username}</h3>

<table>
    <tr>
        <td>ID</td>
        <td>${ID}</td>
    </tr>

    <tr>
        <td>Username</td>
        <td>${Username}</td>
    </tr>

    <tr>
        <td>First name</td>
        <td>${FirstName}</td>
    </tr>

    <tr>
        <td>Last name</td>
        <td>${LastName}</td>
    </tr>

    <tr>
        <td>CNP</td>
        <td>${CNP}</td>
    </tr>

    <tr>
        <td>Wage</td>
        <td>${Wage}</td>
    </tr>
</table>

</body>
</html>