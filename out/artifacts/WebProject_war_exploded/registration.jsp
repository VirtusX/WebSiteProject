<%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 30.10.2016
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.virtusx.service.UserService" %>
<% if(UserService.currentUser !=null)
    response.sendRedirect("/index.jsp");%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
</head>
<header><div align="left"><a class="logo" href="index.jsp">SiteTemplate</a><% if(request.getParameter("signUp")!=null&&request.getParameter("signUp").equals("failed")){%>
    <div class="right">Please, repeat registration</div><%}%></div></header>
<body>
<div class="animated fadeIn" align="center">
    <form class="form reg" action="${pageContext.request.contextPath}/signUp" method="post">
        <br><br>
        <table>
            <tr>
                <td>
            Enter username:
                </td>
                <td>
                    <label>
                        <input minlength="4" maxlength="45" required type="text" name="login">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Enter email:
                </td>
                <td>
                    <label>
                        <input maxlength="45" required type="email" name="email">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    Enter password:
                </td>
                <td>
                    <label>
                        <input minlength="6" maxlength="45" type="password" name="pass">
                    </label>
                </td>
            </tr>
        </table>
        <br><br><br>
        <input class="button small" required type="submit" value="Sign up">
        <br><br>
    </form>
</div>
</body>
</html>
