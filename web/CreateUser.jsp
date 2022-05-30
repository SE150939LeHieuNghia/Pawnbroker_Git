<%-- 
    Document   : CreateUser
    Created on : May 14, 2022, 4:52:46 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <style>
            .warning{
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Create new user</h1>
        <form action="MainController" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>Tài khoản: </td>
                        <td><input type="text" name="id"></td>
                        <td>Họ và tên: </td>
                        <td><input type="text" name="name"></td>
                        <td>SĐT: </td>
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_ID")!=null){%>!!!<%=session.getAttribute("ERROR_ID")%><%};%></td>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_NAME")!=null){%>!!!<%=session.getAttribute("ERROR_NAME")%><%};%></td>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_PHONE")!=null){%>!!!<%=session.getAttribute("ERROR_PHONE")%><%};%></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu: </td>
                        <td><input type="text" name="password"></td>
                        <td>Xác nhận: <br/>mật khẩu</td>
                        <td><input type="text" name="confirm"></td> 
                    </tr>
                    <tr>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_PASSWORD")!=null){%><%=session.getAttribute("ERROR_PASSWORD")%><%};%></td>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_CONFIRM")!=null){%><%=session.getAttribute("ERROR_CONFIRM")%><%};%></td>
                    </tr>
                    <tr>
                        
                        <td>Tên tiệm: </td>
                        <td><input type="text" name="storeName"></td>
                        <td>Địa chỉ: </td>
                        <td><input type="text" name="storeAddress"></td>
                        <td>Mã mở: <br/>tài khoản</td>
                        <td><input type="text" name="key"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_STORENAME")!=null){%><%=session.getAttribute("ERROR_STORENAME")%><%};%></td>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_STOREADDRESS")!=null){%><%=session.getAttribute("ERROR_STOREADDRESS")%><%};%></td>
                        <td></td>
                        <td class="warning"><%if(session.getAttribute("ERROR_KEY")!=null){%><%=session.getAttribute("ERROR_KEY")%><%};%></td>
                    </tr>
                </tbody>
            </table>
<input type="submit" name="action" value="Create new account">
        </form>
    </body>
</html>
