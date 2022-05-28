<%-- 
    Document   : CompanyPage
    Created on : May 24, 2022, 12:34:33 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainController">
            <input type="submit" name="action" value="Get Key">
        </form>
        Key : <%=session.getAttribute("Key")%>
        <%=request.getAttribute("ERROR")%>
    </body>
</html>
