<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${emp.first_name} ${emp.last_name}</h1>
        <% 
            out.println(session.getId());
            out.println(new Date(session.getCreationTime()));
            out. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
        %>
        
        <a href="Logout">Logout</a>
    </body>
</html>
