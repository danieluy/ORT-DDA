<%-- 
    Document   : jsp1
    Created on : 15-jun-2017, 22:05:25
    Author     : docenteFI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int contador=0;
    
    %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%contador++;%>
        
        <h1>Hello World!</h1>
        <h1>Fecha: <%=new java.util.Date().toString()%></h1>
        <h1>Contador: <%=contador%>
        </h1>
    </body>
</html>
