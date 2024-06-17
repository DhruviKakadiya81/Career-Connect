/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.Job;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
@Named(value = "companyJobCdi")
@RequestScoped
public class CompanyJobCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<Job> CompanyJobCollection;
    Job CompanyJobTbl;
    GenericType<Collection<Job>> CompanyJobGeneric;
    
    
    @Inject
    private CompanyCdi companyCdi;

    @PostConstruct
    public void init() {
        findJobByCompanyId(companyCdi.getLoggedInUser().getUserId());
    }
    
    public CompanyJobCdi() {
        
        career_Client=new Career_Connect_Client();
        
        CompanyJobCollection=new ArrayList<>();
        CompanyJobTbl=new Job();
        CompanyJobGeneric=new GenericType<Collection<Job>>(){};
    }
   
    
    public Collection<Job> getCompanyJobCollection() {
        return CompanyJobCollection;
    }

    public void setCompanyJobCollection(Collection<Job> CompanyJobCollection) {
        this.CompanyJobCollection = CompanyJobCollection;
    }

    public Job getCompanyJobTbl() {
        return CompanyJobTbl;
    }

    public void setCompanyJobTbl(Job CompanyJobTbl) {
        this.CompanyJobTbl = CompanyJobTbl;
    }
    
    public void findJobByCompanyId(int id) {
        response=career_Client.searchJobByCompanyId(Response.class, String.valueOf(id));
        CompanyJobCollection=response.readEntity(CompanyJobGeneric);
    } 
    
    public String GotoJobInsert(){
        return "InsertJob";
    }
    
    public String InsertJob(){
            LocalDate today = LocalDate.now();
            
            Date ExpirationDate = CompanyJobTbl.getExpirationDate(); // Initialize interviewDate
            String ExpirationDateStr = new SimpleDateFormat("yyyy-MM-dd").format(ExpirationDate);
            
           career_Client.InsertJob(String.valueOf(companyCdi.getLoggedInUser().getUserId()), CompanyJobTbl.getJobTitle(), CompanyJobTbl.getDescription(), CompanyJobTbl.getTechnology(), CompanyJobTbl.getQualification(), CompanyJobTbl.getExperience(), String.valueOf(CompanyJobTbl.getSalary()), CompanyJobTbl.getStatus(), CompanyJobTbl.getJobType(), String.valueOf(today), ExpirationDateStr);
           return "DisplayJob?faces-redirect=true";
    }
    
    public String deleteJob(int id){
        career_Client.deleteJob(String.valueOf(id));
        return "DisplayJob?faces-redirect=true";
    }
    
}
