
<%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 29.10.2016
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.virtusx.service.UserService" %>
<% if(UserService.currentUser !=null)
    response.sendRedirect("/index.jsp");%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
</head>
<header><div align="left"><a class="logo" href="index.jsp">SiteTemplate</a><%if(request.getParameter("login")!=null&&request.getParameter("login").equals("error")) {%>
    <div class="right">User not found! Please retry!</div><%}%></div>
</header>
<body>
<div class="animated fadeIn"  align="center">
    <form action="${pageContext.request.contextPath}/login" method="post" class="form">
        <br><br>
        <table>
            <tr>
            <td>
            Enter login or e-mail:
            </td>
                <td>
                    <label>
                        <input maxlength="45" required name="login" type="text">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
            Enter password:
                </td>
                <td>
                    <label>
                        <input maxlength="45" required name="pass" type="password">
                    </label>
                </td>
            </tr>
        </table>
        <br><br><br>
        <input class="button  small" type="submit" name="ok" value="Sign in">
        <br><br>
    </form>
</div>
</body>
</html>
