/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Record;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author HP
 */
@Named(value = "keepRecord")
@SessionScoped
public class KeepRecord implements Serializable {

    static String username;
    static String password;
    
    public KeepRecord() {
        username=null;
        password=null;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        KeepRecord.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        KeepRecord.password = password;
    }
    
    public static void reset() {
        username=null;
        password=null;
    }
    
}
