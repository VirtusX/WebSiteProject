<%@ page import="com.virtusx.service.GameService" %><%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 03.11.2016
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(GameService.getGame(request.getParameter("name"))==null){%>
<jsp:forward page="index.jsp"/><%}%>
<html>
<head>
    <title><%=request.getParameter("name")%></title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
</head>
<header> <div align="left"><a class="logo" href="index.jsp">SiteTemplate</a><%if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("false")) {%>
    <div class="right">Game hasn't been updated! Please, retry!</div><%}
    else if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("true")) {%><div class="right"> Game successfully updated!</div><%}%>
</div>
</header>
<body>
<div class="block2">
<img class="img2" src="<%=GameService.getGame(request.getParameter("name")).getGamePic()%>">
</div>
<div class="block b1">
    <table class="t">
        <tr>
            <td class="td">Name of the game: <%=GameService.getGame(request.getParameter("name")).getGameName()%></td>
        </tr>
        <tr>
            <td class="td">Authors of the game: <%=GameService.getGame(request.getParameter("name")).getGameAuthors()%></td>
        </tr>
        <tr>
            <td class="td">Couple words about game: <%=GameService.getGame(request.getParameter("name")).getGameAbout()%></td>
        </tr>
    </table>
    <a class="edit right" href="edit_game.jsp?game=edit&name=<%=request.getParameter("name")%>">Edit game description</a>
</div>
</body>
</html>
