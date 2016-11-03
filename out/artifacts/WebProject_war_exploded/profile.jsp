<%--
  Created by IntelliJ IDEA.
  User: x-13
  Date: 31.10.2016
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.virtusx.service.UserService" %>
<%@ page import="com.virtusx.service.GameService" %>
<% if(UserService.currentUser==null)
    response.sendRedirect("login.jsp");%>
<!DOCTYPE html>
<html class="animated fadeIn">
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/animate.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
    <script>
        webshims.setOptions('forms-ext', {types: 'date'});
        webshims.polyfill('forms forms-ext');
        $.webshims.formcfg = {
            en: {
                dFormat: '-',
                dateSigns: '-',
                patterns: {
                    d: "yy-mm-dd"
                }
            }
        };
    </script>
</head>
<header> <div align="left"><a class="logo" href="index.jsp">SiteTemplate</a><%if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("false")) {%>
    <div class="right">Entered passwords are different! Please retry!</div><%}
    else if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("true")) {%><div class="right"> Profile successfully updated!</div><%}%>
</div>
</header>
<body>
<div class="block">
    <form class="f1" action="${pageContext.request.contextPath}/profile" method="post">
        <p class="first">Enter password: <input minlength="6" maxlength="45" title="pass1" type="password" name="pass1">
        <p>Repeat entry: <input minlength="6" maxlength="45" type="password" title="pass2" name="pass2"></p>
        <p class="first">Enter e-mail: <input maxlength="45" title="mail" type="email" name="mail">
        <p>Enter avatar url: <input maxlength="100" title="pic" type="url" name="pic">
        <p class="first">Enter birthday: <br> <input title="birth" type="date" name="date">
        <p>Enter location: <input maxlength="100" title="location" type="text" name="loc">
        <p>Choose your favourite game:
        <div class="container">
        <%for(String game: GameService.getGamesList()){
            %><input type="checkbox" name="g" value="<%=game%>" title="<%=game%>"><%=game%><br><%}%>
        <input type="checkbox" name="g" value="new game" title="newGame">Add new game
        </div>
        <p>Write something about yourself: <textarea maxlength="300" rows="2" cols="39" title="about" name="about"></textarea>
        <br>
        <input id="update" title="Update profile" type="submit" value="Update">
    </form>
</div>
<div class="block b1">
    <% if(UserService.currentUser.getUserPic()!=null){%>
    <img class="img" src="<%=UserService.currentUser.getUserPic()%>" alt="avatar">
    <%}%>
<table>
    <% for (String e : UserService.userData()){%>
    <tr>
        <td class="td"><%=e%></td>
    </tr>
    <%}%>
    <% if(!GameService.getGamesName().isEmpty()){%>
    <tr>
        <td class="td">Favourite game: <% for (int i = 0; i<GameService.getGamesName().size();i++){%>
            <%if(i!=GameService.getGamesName().size()-1){%>
            <a href="game.jsp?name=<%=GameService.getGamesName().get(i)%>"><%=GameService.getGamesName().get(i)+","%></a>
            <%} else {%>
            <a href="game.jsp?name=<%=GameService.getGamesName().get(i)%>"><%=GameService.getGamesName().get(i)%></a><%}}%></td>
    </tr><%}%>
</table>
</div>
</body>
</html>
