<%-- 
    Document   : ForgotPass
    Created on : May 14, 2022, 4:53:04 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>
        <style>
            .button{
                color: red;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center; color:blue ">Forgot Password </h1><br/>
         &ensp;  &ensp;  <br/>
         &ensp;  &ensp;
         &ensp; 
         <form action="MainController" method="POST">
         <table border="0" style="text-align: center">
            <tbody>
                <tr>
                    <td>ID<td/><td> <input type="text" name="id"></td>
                    <td>Name<td/><td> <input type="text" name="name"></td>
                    <td>Phone number <td/><td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td>Password <td/><td><input type="password" name="password"></td>
                    <td>Confirm <td/><td><input type="password" name="confirm"></td>
                    <td>Key <td/><td><input type="text" name="key"></td>
                </tr>
            </tbody>
        </table>
             <input class="button" type="submit" value="Get Key" name="action"> &ensp; <%=session.getAttribute("Key") %><br/>
<input class="button" type="submit" value="Return" name="action"> &ensp;
<input class="button" type="submit" value="Submit" name="action">
         </form>
    </body>
</html>
