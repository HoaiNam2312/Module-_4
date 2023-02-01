<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 28/01/2023
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/index" method="post">
    <label for="english">English: </label>
    <input type="text" id="english" name="english" value="${english}"><br><br>
    <label for="vietnamese">Vietnamese: </label>
    <input type="text" id="vietnamese" name="vietnamese" value="${vietnamese}"><br><br>
    <button type="submit">Translate</button>
  </form>
  </body>
</html>
