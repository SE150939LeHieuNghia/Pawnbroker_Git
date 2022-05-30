<%-- 
    Document   : Homepage
    Created on : May 16, 2022, 8:39:38 PM
    Author     : user
--%>

<%@page import="lhn.manager.ManagerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <%
            ManagerDTO manager =(ManagerDTO) session.getAttribute("MANAGER");
            if(manager==null){
                request.setAttribute("Error_Login", "Please login first");
                request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            }
        %>
        <h1>Easy</h1>
    </body>
</html>
