<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin panel</title>
</head>

<body>
<h1>Admin functionality</h1>

<form action="individualClientRegisterPage" method="get">
    <table>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create individual client">
            </td>
        </tr>
    </table>
</form>

<form action="legalClientRegisterPage" method="get">
    <tr>
        <td colspan="2">
            <input type="submit" value="Create legal client">
        </td>
    </tr>
</form>

<form action="legalClientRegisterPage" method="get">
    <tr>
        <td colspan="2">
            <input type="submit" value="Remove ">
        </td>
    </tr>
</form>

<form action="createDebitBankAccount" method="post">
    <tr>
        <td colspan="2">
            <input type="submit" value="Create debit bank account">
        </td>
    </tr>
</form>

<form action="createCreditBankAccount" method="post">
    <tr>
        <td colspan="2">
            <input type="submit" value="Create credit bank account">
        </td>
    </tr>
</form>

</body>

</html>
