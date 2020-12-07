<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Create legal client account</title>
</head>

<body>
<h1>Create legal client account</h1>

<form action="createLegalClient" method="post">
    <table>
        <tr>
            <td><label path="username">Username</label></td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td><label path="password">Password</label></td>
            <td><input type="text" name="password"></td>
        </tr>

        <tr>
            <td><label path="companyName">Company name</label></td>
            <td><input type="text" name="companyName"></td>
        </tr>

        <tr>
            <td><label path="cui">CUI</label></td>
            <td><input type="text" name="cui"></td>
        </tr>

        <tr>
            <td><label path="costTransaction">Cost transaction</label></td>
            <td><input type="number" name="costTransaction"></td>
        </tr>

        <tr>
            <td><label path="capital">Capital</label></td>
            <td><input type="number" name="capital"></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Create legal client">
            </td>
        </tr>
    </table>
</form>

</body>

</html>
