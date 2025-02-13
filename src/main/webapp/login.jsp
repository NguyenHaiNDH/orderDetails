<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/02/2025
  Time: 4:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Page</h2>
<form action="login" method="post">
    <label>Username: <input type="text" name="username" required></label><br>
    <label>Password: <input type="password" name="password" required></label><br>
    <input type="submit" value="Login">
</form>
<% if (request.getAttribute("errorMessage") != null) { %>
<p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>
</body>
</html>

