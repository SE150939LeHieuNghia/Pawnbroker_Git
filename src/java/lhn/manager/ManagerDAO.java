/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import lhn.tils.DBUtils;

/**
 *
 * @author user
 */
public class ManagerDAO {
    private final String LOGIN="SELECT fullName, phone, storeName, storeAddress "
            + "FROM tblManager "
            + "WHERE personalID =? AND password =? ";
    public ManagerDTO checkLogin (String id, String password) throws SQLException{
        ManagerDTO manager=null;
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try{
            conn=DBUtils.getConnection();
            if(conn!=null){
                stm=conn.prepareStatement(LOGIN);
                stm.setString(1, id);
                stm.setString(2, password);
                rs=stm.executeQuery();
                if(rs.next()){
                    String fullname=rs.getString("fullName");
                    int phone=rs.getInt("phone");
                    String storeName=rs.getString("storeName");
                    String storeAddress=rs.getString("storeAddress");
                   manager=new ManagerDTO(id, fullname, password, phone, storeName, storeAddress);
                   
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        return manager;
    }
    public boolean createUser(String id,String password ){
        ManagerDTO manager=new ManagerDTO();
        
        return true;
    }
}
