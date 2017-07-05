<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

  String nombre = (String) session.getAttribute("nombre");
  String password = (String) session.getAttribute("password");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">
        <title>Buscaminas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Bienvenid@ <%=nombre%></h1>
    </body>
</html>
