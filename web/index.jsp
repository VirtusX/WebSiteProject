<%@ page import="com.virtusx.service.UserService" %>
<%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 29.10.2016
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="assets/scripts/main.js"></script>
  </head>
  <body>
  <header>
    <div align="left">
      <a class="logo animated fadeInLeftBig" href="index.jsp">SiteTemplate</a>
      <% if (UserService.currentUser == null) {%>
      <div class="right animated fadeInRightBig"><a href="login.jsp">Sign in</a> or <a href="registration.jsp">sign
        up</a></div>
      <%} else {%>
      <form class="right animated fadeInRightBig" action="${pageContext.request.contextPath}/profile" method="post">
        Welcome, <a style="margin-right: 20px;" href="profile.jsp"><%=UserService.currentUser.getUserName()%>
      </a>
            <input class="small button" type="submit" name="exit" value="Exit"></form>
      <%}%>
    </div>
  </header>
<div align="center" class="front">
    <p>Welcome to </p>
    <p></p>
  <h1 class="title">VirtusX study site template!</h1>
</div>
</body>
</html>
