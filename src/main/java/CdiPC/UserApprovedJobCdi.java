/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.ApprovedJob;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "userApprovedJobCdi")
@RequestScoped
public class UserApprovedJobCdi {

    
    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<ApprovedJob> UserApprovedJobCollection;
    ApprovedJob UserApprovedJobTbl;
    GenericType<Collection<ApprovedJob>> UserApprovedJobGeneric;
    
    @Inject
    private CompanyCdi companyCdi;

    @PostConstruct
    public void init() {
        findApprovedJobByUser(companyCdi.getLoggedInUser().getUserId());
    }

    public Collection<ApprovedJob> getUserApprovedJobCollection() {
        return UserApprovedJobCollection;
    }

    public void setUserApprovedJobCollection(Collection<ApprovedJob> UserApprovedJobCollection) {
        this.UserApprovedJobCollection = UserApprovedJobCollection;
    }

    public ApprovedJob getUserApprovedJobTbl() {
        return UserApprovedJobTbl;
    }

    public void setUserApprovedJobTbl(ApprovedJob UserApprovedJobTbl) {
        this.UserApprovedJobTbl = UserApprovedJobTbl;
    }
   
   
    public UserApprovedJobCdi() {
        
        career_Client=new Career_Connect_Client();
        
        UserApprovedJobCollection=new ArrayList<>();
        UserApprovedJobTbl=new ApprovedJob();
        UserApprovedJobGeneric=new GenericType<Collection<ApprovedJob>>(){};
    }
    
    public void findApprovedJobByUser(int id) {
        response=career_Client.findApprovedJobByUser(Response.class, String.valueOf(id));
        UserApprovedJobCollection=response.readEntity(UserApprovedJobGeneric);
    }
}
