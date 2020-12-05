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
<p>- Legal client -</p>

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
        <td>Company name</td>
        <td>${CompanyName}</td>
    </tr>

    <tr>
        <td>CUI</td>
        <td>${CUI}</td>
    </tr>

    <tr>
        <td>Cost transaction</td>
        <td>${CostTransaction}</td>
    </tr>

    <tr>
        <td>Capital</td>
        <td>${Capital}</td>
    </tr>
</table>

</body>
</html>