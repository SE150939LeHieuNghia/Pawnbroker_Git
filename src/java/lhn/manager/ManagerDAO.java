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
import lhn.tils.DBUtils;

/**
 *
 * @author user
 */
public class ManagerDAO {
    private final String LOGIN="SELECT fullName, phoneNumber, storeName, storeAddress, confirmKey "
            + "FROM tblManager "
            + "WHERE managerID =? AND password =? ";
    private final String CREATE1="INSERT INTO tblManager ( managerID, password, fullName, phoneNumer, storeName, storeAddress, confirmKey) VALUES (?, ?, ?, ?, ?, ?, ?) ";
    private final String CREATE="Insert tblManager (managerID,password,fullName,phoneNumber,storeName,storeAddress,confirmKey) values (? , ? , ? , ? , ? , ? , ?)";
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
                    int phone=rs.getInt("phoneNumber");
                    String storeName=rs.getString("storeName");
                    String storeAddress=rs.getString("storeAddress");
                    String key=rs.getString("confirmKey");
                   manager=new ManagerDTO(id, fullname, password, phone, storeName, storeAddress,key );
                   
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
    public boolean createUser(String id,String name, int phone, String password, String storeName, String storeAddress, String key) throws SQLException{
        ManagerDTO manager=new ManagerDTO();
        Connection conn=null;
        PreparedStatement stm=null;
        try{
            conn=DBUtils.getConnection();
            if(conn!=null){
               stm=conn.prepareStatement(CREATE); 
               stm.setString(1, id);
                stm.setString(2, password);
                stm.setString(3, name);
                stm.setInt(4, phone);
                stm.setString(5, storeName);
                stm.setString(6, storeAddress);
                stm.setString(7, key);
                if(stm.executeUpdate()>0) return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        return false;
    }
}
