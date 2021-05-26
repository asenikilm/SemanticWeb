<%-- 
    Document   : index
    Created on : May 19, 2021, 12:41:05 AM
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
    background-color: #57D8E7; /* Цвет фона */
   }
  </style>
    </head>
    <body>
        <h1>Hello World! My name is Inesa Mlik.</h1>
        
        <%!int myInt=0;%>
            <%myInt++;%>
            <p><%=myInt%></p>
            
            <p><b>Add personal info</b></p>
                    
            <form action="<%=request.getContextPath()%>/servlet" method="post">
                <label for="name">Name:</label><br>
                <input type="text" name="name"/><br>
                <label for="surname">Surname:</label><br>
                <input type="text" name="surname"><br>
                <label for="age">Age:</label><br>
                <input type="text" name="age"><br><br>
                <input type="submit" value="Ok"/>                
            </form>
            
    </body>
</html>