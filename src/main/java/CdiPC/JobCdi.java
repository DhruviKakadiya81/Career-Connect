/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.Job;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "jobCdi")
@RequestScoped
public class JobCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<Job> jobCollection;
    Job jobTbl;
    GenericType<Collection<Job>> jobGeneric;
    
    String searchKeyword;
    private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    
    public JobCdi() {
        
        career_Client=new Career_Connect_Client();
        
        jobCollection=new ArrayList<>();
        jobTbl=new Job();
        jobGeneric=new GenericType<Collection<Job>>(){};
        
    }
    
    @PostConstruct
    public void init() {
        if (companyId != 0) {
            fetchJobsByCompanyId();
        }
    }
    
    
//    public Collection<Job> getJobCollection() {
//        if(searchKeyword!=null){
//            response=career_Client.searchJobsByTitle(Response.class,searchKeyword);
//            jobCollection=response.readEntity(jobGeneric);
//            return jobCollection;
//        }else{
//            response=career_Client.getAllJobs(Response.class);
//            jobCollection=response.readEntity(jobGeneric);
//            return jobCollection;
//        }
//    }
    
    
     public Collection<Job> getJobCollection() {
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            response = career_Client.searchJobsByTitle(Response.class, searchKeyword);
            jobCollection = response.readEntity(jobGeneric);
        } else {
            if (companyId != 0) {
                fetchJobsByCompanyId();
            } else {
                response = career_Client.getAllJobs(Response.class);
                jobCollection = response.readEntity(jobGeneric);
            }
        }
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    public Job getJobTbl() {
        return jobTbl;
    }

    public void setJobTbl(Job jobTbl) {
        this.jobTbl = jobTbl;
    }
    
    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }
    
    public String searchJobUsingTitle()
    {
         return "DisplayJob";
    }
    
    private void fetchJobsByCompanyId() {
        try {
            response = career_Client.searchJobByCompanyId(Response.class, String.valueOf(companyId));
            jobCollection = response.readEntity(jobGeneric);
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }
    
}
