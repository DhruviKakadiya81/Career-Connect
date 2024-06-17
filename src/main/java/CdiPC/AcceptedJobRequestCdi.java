/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.JobRequest;
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
@Named(value = "acceptedJobRequestCdi")
@RequestScoped
public class AcceptedJobRequestCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<JobRequest> acceptedJobRequestCollection;
    JobRequest acceptedJobRequestTbl;
    GenericType<Collection<JobRequest>> acceptedJobRequestGeneric;
    
    @Inject
    private CompanyCdi companyCdi;

    @PostConstruct
    public void init() {
        findJobRequestsByCompanyIdAndAccepted(companyCdi.getLoggedInUser().getUserId());
    }
    
    public AcceptedJobRequestCdi() {
        
        career_Client=new Career_Connect_Client();
        
        acceptedJobRequestCollection=new ArrayList<>();
        acceptedJobRequestTbl=new JobRequest();
        acceptedJobRequestGeneric=new GenericType<Collection<JobRequest>>(){};
    }
    
    public Collection<JobRequest> getAcceptedJobRequestCollection() {
        return acceptedJobRequestCollection;
    }

    public void setAcceptedJobRequestCollection(Collection<JobRequest> acceptedJobRequestCollection) {
        this.acceptedJobRequestCollection = acceptedJobRequestCollection;
    }

    public JobRequest getAcceptedJobRequestTbl() {
        return acceptedJobRequestTbl;
    }

    public void setAcceptedJobRequestTbl(JobRequest acceptedJobRequestTbl) {
        this.acceptedJobRequestTbl = acceptedJobRequestTbl;
    }
    
    
    public void findJobRequestsByCompanyIdAndAccepted(int id) {
        response=career_Client.findJobRequestsByCompanyIdAndStatus(Response.class, String.valueOf(id), "Accepted");
        acceptedJobRequestCollection=response.readEntity(acceptedJobRequestGeneric);
    }
    
    int companyid,jobid,userid;
    int jobRequestId;

    public int getJobRequestId() {
        return jobRequestId;
    }
    public void setJobRequestId(int jobRequestId) {
        this.jobRequestId = jobRequestId;
    }
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
    
    public String GoToScheduleInterview(JobRequest j){
        this.acceptedJobRequestTbl=j;
        this.companyid=j.getCompanyId().getUserId();
        this.jobid=j.getJobId().getJobId();
        this.userid=j.getUserId().getUserId();
        this.jobRequestId=j.getJobRequestId();
        return "ScheduleInterview";
    }
    
}
