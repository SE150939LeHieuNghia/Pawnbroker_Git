<%-- 
    Document   : CreateBill
    Created on : May 14, 2022, 4:52:46 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create new user</h1>
        <form action="CreateController" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>Tài khoản </td>
                        <td><input type="text" name="id"></td>
                        <td>Họ và tên: </td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Mã món đồ</td>
                        <td><input type="text" name="itemid"></td>
                        <td>Tên món đồ</td>
                        <td><input type="text" name="itemname"></td>
                    </tr>
                    <tr>
                        <td>Tiền cầm</td>
                        <td><input type="text" name="money"></td>
                        <td>Lãi suất</td>
                        <td><input type="text" name="interest"></td>
                    </tr>
                    <tr>
                        
                        <td>Ngày đưa</td>
                        <td>
<input type="date" name="bday"></td>
                        <td>Thời hạn cầm </td>
                        <td>
                            <input type="text" name="payments"> ngày
                        </td>
                    </tr>
                    <tr>
                        <td>Hình ảnh : </td>
                        <td>  <input type="file" name="imange" accept="image/*"></td>
                    </tr>
                </tbody>
            </table>
<input type="submit" name="action" value="Create">
        </form>
    </body>
</html>
