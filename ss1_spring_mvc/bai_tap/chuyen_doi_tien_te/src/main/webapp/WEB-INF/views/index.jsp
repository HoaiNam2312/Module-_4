<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 28/01/2023
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/index" method="post">
    <label for="USD">USD: </label>
    <input type="number" id="USD" name="usd" value="${usd}"><br><br>
    <label for="RESULT">VND: </label>
    <input type="number" id="RESULT" name="result"  value="${result}"><br><br>
    <input type="submit" value="Convert">
  </form>

  </body>
</html>
