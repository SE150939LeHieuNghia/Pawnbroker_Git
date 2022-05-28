<%-- 
    Document   : login
    Created on : May 12, 2022, 6:42:33 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            .comment{
                color: red;
            }
        </style>
    </head>
    <body>
        <h1 style="align-content: center">Manage Store System</h1>
        <form action="MainController" method="POST">
            <%String id = (String) request.getAttribute("Error_Login_ID");%>
            <%String password = (String) request.getAttribute("Error_Login_Password");%>
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id"</td>
                        <%if (id != null) {%>
                    <td class="comment"><%=id%></td>
                    <%}%>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"</td>
                        <%if (password != null) {%>
                    <td class="comment"><%=password%></td>
                    <%}%>
                </tr>
            </table>

            <input type="submit" name="action" value="Create User"> <input type="submit" name="action" value="Forgot Password"> <input type="submit" name="action" value="Login"> 
            <%String login=(String)request.getAttribute("Error_Login"); if(login!=null){%><a class="comment"><%=login%></a> <%}%><br/>
            <input type="submit" name="action" value="Company Page">
           </form> 
    </body>
</html>
