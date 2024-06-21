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
import EntityPC.Resume;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

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
    
    public String AcceptRequest(@PathParam("jobRequestId") int jobRequestId) {
    try {
        career_Client.ChangeJobRequestStatus(String.valueOf(jobRequestId),"Accepted");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Job request accepted successfully"));
    } catch (ClientErrorException e) {
    }
    return "CompanyJobRequest?faces-redirect=true";
    }
    
    public String CancelRequest(@PathParam("jobRequestId") int jobRequestId) {
    try {
        career_Client.ChangeJobRequestStatus(String.valueOf(jobRequestId),"Cancel");
    } catch (ClientErrorException e) {
    }
    return "CompanyJobRequest?faces-redirect=true";
}
    
    
    public void findJobRequestsByUserId(int userId){
        response=career_Client.findJobRequestsByUserId(Response.class, String.valueOf(userId));
        jobRequestCollection=response.readEntity(jobRequestGeneric);
    } 
    
    
    // In your managed bean (jobRequestCdi)
private Long selectedJobRequestId;

public Long getSelectedJobRequestId() {
    return selectedJobRequestId;
}

public void setSelectedJobRequestId(Long selectedJobRequestId) {
    this.selectedJobRequestId = selectedJobRequestId;
}


 private String resumeUrl;
 
  public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    public void viewResume(int userId) {
        try {
            // Query to get the resume by userId
            Resume resume = entityManager.createQuery("SELECT r FROM Resume r WHERE r.userId.userId = :userId", Resume.class)
                              .setParameter("userId", userId)
                              .getSingleResult();

            if (resume != null) {
                // Construct the URL to the resume
                resumeUrl = "../uploaded_resume/" + resume.getPdfName();
                System.out.println(resumeUrl);
            } else {
                resumeUrl = "Resume not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            resumeUrl = "Error retrieving resume";
        }
    }
    
    
    
    
}
