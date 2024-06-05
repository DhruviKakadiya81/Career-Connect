/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.Job;
import EntityPC.JobRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import CdiPC.CompanyCdi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.PathParam;
import CdiPC.CompanyCdi;

/**
 *
 * @author HP
 */
@Named(value = "jobRequestCdi")
@RequestScoped
public class JobRequestCdi {

    Career_Connect_Client career_Client;
    
    Response response;

    Collection<JobRequest> jobRequestCollection;
    JobRequest jobRequestTbl;
    GenericType<Collection<JobRequest>> jobRequestGeneric;
    
    @Inject
    private CompanyCdi companyCdi;

    @PostConstruct
    public void init() {
        findJobRequestsByCompanyIdAndStatus(companyCdi.getLoggedInUser().getUserId());
    }
    
    public JobRequestCdi() {
        
        career_Client=new Career_Connect_Client();
        
        jobRequestCollection=new ArrayList<>();
        jobRequestTbl=new JobRequest();
        jobRequestGeneric=new GenericType<Collection<JobRequest>>(){};
    }
    
    public Collection<JobRequest> getJobRequestCollection() {
        return jobRequestCollection;
    }
    
    public void setJobRequestCollection(Collection<JobRequest> jobRequestCollection) {
        this.jobRequestCollection = jobRequestCollection;
    }

    public JobRequest getJobRequestTbl() {
        return jobRequestTbl;
    }

    public void setJobRequestTbl(JobRequest jobRequestTbl) {
        this.jobRequestTbl = jobRequestTbl;
    }
    
    int companyid,jobid,userid;

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
    
    
    @Transactional
        public String InsertJobRequest(int companyid, int jobid, int userid){
            System.out.println("Company ID: " + companyid);
            System.out.println("Job ID: " + jobid);
            System.out.println("User ID: " + userid);
            career_Client.requestJob(String.valueOf(companyid), String.valueOf(jobid), String.valueOf(userid), "Hello", "Pending", "2024-05-25");
            return "DisplayJob";
     }
        
        
    public void findJobRequestsByCompanyIdAndStatus(int id) {
        response=career_Client.findJobRequestsByCompanyIdAndStatus(Response.class, String.valueOf(id), "Pending");
        jobRequestCollection=response.readEntity(jobRequestGeneric);
    }
    
    public void findJobRequestsByCompanyIdAndAccepted(int id) {
        response=career_Client.findJobRequestsByCompanyIdAndStatus(Response.class, String.valueOf(id), "Accepted");
        jobRequestCollection=response.readEntity(jobRequestGeneric);
    }
    

    public String AcceptRequest(@PathParam("jobRequestId") int jobRequestId) {
    try {
        career_Client.ChangeJobRequestStatus(String.valueOf(jobRequestId),"Accepted");
    } catch (ClientErrorException e) {
    }
    return "CompanyJobRequest";
    }
    
    public String CancelRequest(@PathParam("jobRequestId") int jobRequestId) {
    try {
        career_Client.ChangeJobRequestStatus(String.valueOf(jobRequestId),"Cancel");
    } catch (ClientErrorException e) {
    }
    return "CompanyJobRequest";
}
    
    
    public void findJobRequestsByUserId(int userId){
        response=career_Client.findJobRequestsByUserId(Response.class, String.valueOf(userId));
        jobRequestCollection=response.readEntity(jobRequestGeneric);
    } 
    
    public String GoToScheduleInterview(){
        return "ScheduleInterview";
    }
    
    
}
