/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.key;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import lhn.tils.DBUtils;

/**
 *
 * @author user
 */
public class KeyDAO {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaUpperCase = alpha.toUpperCase();
    private static final String digits = "0123456789";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static Random generator = new Random();
    private static final String ADD = "INSERT INTO tblKey (confirmKey,statusKey) values (?, ?) ";
    private static final String CHECK = "SELECT statusKey FROM tblKey WHERE confirmKey = ? ";
    private static final String UPDATE = "UPDATE tblKey SET statusKey = 'True' WHERE confirmKey = ? ";
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public int checkKey(String key) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(CHECK);
                stm.setString(1, key);
                rs = stm.executeQuery();
                if (rs.next()) {
                   if(rs.getBoolean("statusKey"))return 1;
                   else return -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public KeyDTO getKeyRandom() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        String code=null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                do{code = randomAlphaNumeric(8);
                }while(checkKey(code)==1);
                if (code != null) {
                    KeyDTO key = new KeyDTO();
                    key.setKey(code);
                    stm = conn.prepareStatement(ADD);
                    stm.setString(1, code);
                    stm.setBoolean(2, key.isStatus());
                    if (stm.executeUpdate() > 0) {
                        return key;
                    }
//            }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    public boolean updateStatus(String key) throws SQLException{
        Connection conn=null;
        PreparedStatement stm=null;
        try{
            conn=DBUtils.getConnection();
            if(conn!=null){
                stm=conn.prepareStatement(UPDATE);
                stm.setString(1, key);
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
