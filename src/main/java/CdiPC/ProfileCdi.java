/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.UserMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "profileCdi")
@RequestScoped
public class ProfileCdi {
    
    @Inject
    private Career_Connect_Client careerClient;
    
    private Collection<UserMaster> userCollection;
    private UserMaster userTbl;
    private GenericType<Collection<UserMaster>> userGeneric;

    public ProfileCdi() {
        userCollection = new ArrayList<>();
        userTbl = new UserMaster();
        userGeneric = new GenericType<Collection<UserMaster>>(){};
    }

    public Collection<UserMaster> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<UserMaster> userCollection) {
        this.userCollection = userCollection;
    }

    public UserMaster getUserTbl() {
        return userTbl;
    }

    public void setUserTbl(UserMaster userTbl) {
        this.userTbl = userTbl;
    }

    public String saveProfile() {
        String fname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("fname");
       String lname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lname");
       String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
       String password = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password");
       String mobileno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mobileno");

        if (fname != null && lname != null && email != null && password != null && mobileno!=null) {
            try {
                careerClient.userRegistration(fname, lname, email, mobileno, userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), password);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("fname");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lname");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("email");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("password");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("mobileno");

                return "success";
            } catch (Exception e) {
                // Handle the exception
                return "error";
            }
        } else {
            // Handle the case where session values are null
            return "error";
        }
    }
}