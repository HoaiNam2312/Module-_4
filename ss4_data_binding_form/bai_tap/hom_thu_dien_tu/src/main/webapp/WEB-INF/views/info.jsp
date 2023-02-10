<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 06/02/2023
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<table>
    <tr>
        <td>Languages:</td>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams fillter:</td>
        <td>${email.spamsFillter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
