/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class CheckDate {
    public boolean checkDate(String day, String month, String year){
        String date = null;
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        date=day+"/"+month+"/"+year;
        try{
            df.parse(date);
        }catch(Exception e){
            return false;
        }
        return true;
}
}
