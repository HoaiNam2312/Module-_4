<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 03/02/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show result</title>
</head>
<body>
<h3>${mess}</h3>
<c:forEach var="element" items="${list}">
<p>${element}</p>
</c:forEach>
</body>
</html>
