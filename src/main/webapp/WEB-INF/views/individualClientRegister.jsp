<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Create individual client account</title>
</head>

<body>
<h1>Create individual client account</h1>

<form action= "createIndividualClient" method="post">
    <table>
        <tr>
            <td><label path = "username">Username</label></td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td><label path = "password">Password</label></td>
            <td><input type="text" name="password"></td>
        </tr>

        <tr>
            <td><label path = "firstName">First name</label></td>
            <td><input type="text" name="firstName"></td>
        </tr>

        <tr>
            <td><label path = "lastName">Last name</label></td>
            <td><input type="text" name="lastName"></td>
        </tr>

        <tr>
            <td><label path = "cnp">CNP</label></td>
            <td><input type="text" name="cnp"></td>
        </tr>

        <tr>
            <td><label path = "wage">Wage</label></td>
            <td><input type="number" name="wage"></td>
        </tr>

        <tr>
            <td colspan = "2">
                <input type="submit" value="Create individual client">
            </td>
        </tr>
    </table>
</form>

</body>

</html>
