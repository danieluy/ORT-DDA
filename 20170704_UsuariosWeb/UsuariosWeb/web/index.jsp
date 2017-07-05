<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%String msg = request.getParameter("msg");%>
<html>
    <head>
        <title>Bienvenido</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Login</div>
        <br>
        <form action="/usuarios/login" > 
            Nombre <input name="nombre" type="text"> 
            <br><br>
            Password <input name="password" type="password">
            <br><br>
            <%=msg==null?"":msg%>
            <br><br>
            <input value="Login" type="submit">
        </form>
    </body>
</html>
