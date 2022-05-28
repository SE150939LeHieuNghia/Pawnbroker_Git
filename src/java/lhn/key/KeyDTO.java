/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.key;

/**
 *
 * @author user
 */
public class KeyDTO {
    String key;
            boolean status;

    public KeyDTO(String key) {
        this.key = key;
        this.status = false;
    }

    public KeyDTO() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
            
}
