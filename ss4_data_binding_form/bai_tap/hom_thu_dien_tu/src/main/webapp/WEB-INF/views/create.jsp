<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 06/02/2023
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="/update" method="post" modelAttribute="email">
    <table>
        <tr>
            <td colspan="2" ><form:label path="languages"><b>Languages:</b></form:label></td>
            <td colspan="4" ><form:select path="languages" items="${arraylanguages}"></form:select></td>
        </tr>
        <tr>
            <td colspan="2" ><form:label path="pageSize"><b>Page Size:</b></form:label></td>
            <td colspan="4" >Show <form:select path="pageSize" items="${arrayPageSize}"></form:select> emails per page</td>
        </tr>
        <tr>
            <td colspan="2" ><form:label path="spamsFillter"><b>Spams fillter:</b></form:label></td>
            <td colspan="4" ><form:checkbox path="spamsFillter" value="true"></form:checkbox>Enable spams fillter</td>
        </tr>
        <tr>
            <td colspan="2" ><form:label path="signature"><b>Signature:</b></form:label></td>
            <td colspan="4" ><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td colspan="2" ></td>
            <td colspan="4" >
            <button type="submit">Update</button>
            <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
