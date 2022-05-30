/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.manager;

/**
 *
 * @author user
 */
public class ManagerDTO {
    private String personalID;
    private String fullname;
    private String password;
    private int phone;
    private String storeName;
    private String storeAddress;
private String key;
    public ManagerDTO(String personalID, String fullname, String password, int phone, String storeName, String storeAddress, String key) {
        this.personalID = personalID;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.key=key;
    }
    public ManagerDTO() {
        this.personalID = "";
        this.fullname = "";
        this.password = "";
        this.phone = 0;
        this.storeName = "";
        this.storeAddress = "";
        key="";
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

   
 
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
}
