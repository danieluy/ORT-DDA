<%-- 
    Document   : index.jsp
    Created on : 05-jul-2017, 23:24:15
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%-- prevents caching at the proxy server --%>
<%
  response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
  response.setHeader("Pragma", "no-cache"); //HTTP 1.0
  response.setDateHeader("Expires", 0);
%>


<!DOCTYPE html>
<%String mensaje = request.getParameter("mensaje");%>
<html>

    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">
        <title>Buscaminas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

        <div class="container">
            <h1 class="center">Buscaminas</h1>
            <div class="ds-card">
                <h3>Login</h3>
                <form action="loginjugador" method="POST">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="nombre" name="nombre" type="text" autofocus>
                            <label for="nombre">Nombre</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="password" name="password" type="password">
                            <label for="password">Password</label>
                        </div>
                        <div class="input-field col s12">
                            <input class="btn waves-effect" type="submit" value="Ingresar">
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>

        <span id="mensaje" hidden><%=mensaje%></span>
        <script>
            var msj = document.getElementById("mensaje").innerHTML;
            if (msj !== 'null' && msj !== "") {
                Materialize.toast(msj, 5000, 'red lighten-2');
            }
        </script>
    </body>

</html>
