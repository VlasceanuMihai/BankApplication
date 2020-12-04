<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Admin panel</title>
</head>

<body>
<h1>Admin functionality</h1>

<form action= "addUser" method="post">
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><label path = "userName">Username</label></td>--%>
<%--            <td><input type="text" name="userName"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label path = "firstName">First name</label></td>--%>
<%--            <td><input type="text" name="firstName"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label path = "lastName">Last name</label></td>--%>
<%--            <td><input type="text" name="lastName"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label path = "age">Age</label></td>--%>
<%--            <td><input type="number" name="age"></td>--%>
<%--        </tr>--%>

        <tr>
            <td colspan = "2">
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form>

</body>

</html>
