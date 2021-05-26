<%-- 
    Document   : result
    Author     : Inesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <style>
   body {
    background-color: #57E779; /* Цвет фона */
   }
  </style>
    </head>
    <body>
        <h1>Got it, thanks!</h1>
        
        <p><%= (String) request.getAttribute("NString")%></p>
        <p><%= (String) request.getAttribute("SNString")%></p>
        <p><%= (String) request.getAttribute("AString")%></p>
        
        <p><a href="<%=request.getContextPath()%>">Home</a></p>
        
    </body>
</html>
