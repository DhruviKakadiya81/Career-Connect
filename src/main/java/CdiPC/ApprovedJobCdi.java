/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.ApprovedJob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "approvedJobCdi")
@RequestScoped
public class ApprovedJobCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<ApprovedJob> approvedJobCollection;

    public Collection<ApprovedJob> getApprovedJobCollection() {
        return approvedJobCollection;
    }

    public void setApprovedJobCollection(Collection<ApprovedJob> approvedJobCollection) {
        this.approvedJobCollection = approvedJobCollection;
    }

    public ApprovedJob getApprovedJobTbl() {
        return approvedJobTbl;
    }

    public void setApprovedJobTbl(ApprovedJob approvedJobTbl) {
        this.approvedJobTbl = approvedJobTbl;
    }
    ApprovedJob approvedJobTbl;
    GenericType<Collection<ApprovedJob>> approvedJobGeneric;
   
    public ApprovedJobCdi() {
        
        career_Client=new Career_Connect_Client();
        
        approvedJobCollection=new ArrayList<>();
        approvedJobTbl=new ApprovedJob();
        approvedJobGeneric=new GenericType<Collection<ApprovedJob>>(){};
        
    }
    
    public String approvedJobIns(){
         FacesContext facesContext = FacesContext.getCurrentInstance();
            Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
            int companyId = Integer.parseInt(params.get("companyId"));
            int jobId = Integer.parseInt(params.get("jobId"));
            int userId = Integer.parseInt(params.get("userId"));
            int interviewId = Integer.parseInt(params.get("interviewId"));
        LocalDate today = LocalDate.now();
        career_Client.AddApprovedJob(String.valueOf(7), String.valueOf(companyId), String.valueOf(userId), String.valueOf(jobId), String.valueOf(today), approvedJobTbl.getApprovalNote(), approvedJobTbl.getStatus(), String.valueOf(approvedJobTbl.getSalary()));
        career_Client.deleteInterview(String.valueOf(interviewId));
        
        return "DisplayApprovedJob";
    }
    
    public void findApprovedJobByCompany(int id) {
        response=career_Client.findApprovedJobByCompany(Response.class, String.valueOf(id));
        approvedJobCollection=response.readEntity(approvedJobGeneric);
    }
    
    
}
