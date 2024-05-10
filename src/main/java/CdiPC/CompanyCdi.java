/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "companyCdi")
@RequestScoped
public class CompanyCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<UserMaster> userCollection;
    UserMaster userTbl;
    GenericType<Collection<UserMaster>> userGeneric;
    
    public CompanyCdi() {
        career_Client=new Career_Connect_Client();
        
        userCollection=new ArrayList<>();
        userTbl=new UserMaster();
        userGeneric=new GenericType<Collection<UserMaster>>(){};
    }

    public Collection<UserMaster> getUserCollection() {
        response=career_Client.DisplayCompany(Response.class);
//        response=career_Client.findByRoleId(Response.class,String.valueOf(3));
        userCollection=response.readEntity(userGeneric);
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
    
    public String deleteCompany(int id){
        career_Client.deleteById(String.valueOf(id));
        return "DisplayCompany";
    }
    
    public String getCompany(UserMaster u){
        this.userTbl=u;
        return "UpdateCompany";
    }
    
    public String updateCompany(){
        career_Client.updateCompany(String.valueOf(userTbl.getUserId()), userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification());
        return "DisplayCompany";
    }
    
    
    public String companyRegistration(){
        career_Client.companyRegistration(userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(),String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification());
//        career_Client.insertCompany(userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification(),String.valueOf(3));
        return "DisplayCompany";
    }
    
}
