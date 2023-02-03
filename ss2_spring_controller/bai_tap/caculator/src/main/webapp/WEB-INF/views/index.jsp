<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 03/02/2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Caculator</h2>
  <form action="/result" method="post">
    <input type="number" name="soA" id="soA" placeholder="Enter the number A" value="${soA}"><br>
    <input type="number" name="soB" id="soB" placeholder="Enter the number B" value="${soB}"><br>
    <input type="number" name= "result" placeholder="0" value="${result}"><br><br>
    <input type="submit" name="caculation" value="Addition(+)">
    <input type="submit" name="caculation" value="Subtraction(-)">
    <input type="submit" name="caculation" value="Multiplication(X)">
    <input type="submit" name="caculation" value="Division(/)">
  </form>
  </body>
</html>
