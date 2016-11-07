<%@ page import="com.virtusx.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 02.11.2016
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%if(UserService.currentUser!=null){
    if (request.getParameter("game")!=null&&request.getParameter("game").equals("edit")&&request.getParameter("name")==null){
        %><jsp:forward page="index.jsp"/><%}
else{%>
<html>
<head>
    <title><%if(request.getParameter("game").equals("add")){%>Add game<%}else {%>Edit game<%}%></title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
</head>
<header><div align="left"><a class="logo" href="index.jsp">SiteTemplate</a><%if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("false")) {%>
    <div class="right">Game wasn't been added! Please retry!</div><%}%></div></header>
<body>
<div align="center" class="animated fadeInUpBig">
    <form class="form add" action="${pageContext.request.contextPath}/games" method="post">
        <%if(request.getParameter("game")!=null&&request.getParameter("game").equals("edit")){%>
        <input value="<%if(request.getParameter("name")!=null){%><%=request.getParameter("name")%><%}%>" type="hidden" name="name" title="oldName"><%}%>
        <input type="hidden" value="<%=request.getParameter("game")%>" name="game">
        <table class="t">
            <tr>
                <td>
                    <label for="name">Enter name of the game: </label>
                </td>
                <td>
                    <input value="<%if(request.getParameter("name")!=null&&request.getParameter("game").equals("edit")){%><%=request.getParameter("name")%><%}%>" required maxlength="45" id="name" type="text" name="gameName">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="author">Enter author of the game: </label>
                </td>
                <td>
                    <input required maxlength="45" id="author" type="text" name="gameAuthor">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="pic">Enter url of the game picture</label>
                </td>
                <td>
                    <input maxlength="200" id="pic" type="text" name="gamePic">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="about">Describe game in few words</label>
                </td>
                <td>
                    <textarea maxlength="500" cols="27" rows="4" id="about" name="gameAbout"></textarea>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <input type="submit" class="button small" value="<%if(request.getParameter("game").equals("add")){%>add game<%}else {%>edit game<%}%>">
    </form>
</div>
</body>
</html>
<%}
}
else {%><jsp:forward page="index.jsp"/><%}%>