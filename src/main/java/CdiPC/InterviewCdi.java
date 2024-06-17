/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.Interview;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
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
@Named(value = "interviewCdi")
@RequestScoped
public class InterviewCdi {

    Career_Connect_Client career_Client;
    
    Response response;
    
    JobRequestCdi jobRequestCdi;
    
    Collection<Interview> interviewCollection;
    Interview interiewTbl;
    GenericType<Collection<Interview>> interviewGeneric;
    
    
    Collection<Interview> UserInterviewCollection;

    public Collection<Interview> getUserInterviewCollection() {
        return UserInterviewCollection;
    }

    public void setUserInterviewCollection(Collection<Interview> UserInterviewCollection) {
        this.UserInterviewCollection = UserInterviewCollection;
    }

    public Interview getUserInteriewTbl() {
        return UserInteriewTbl;
    }

    public void setUserInteriewTbl(Interview UserInteriewTbl) {
        this.UserInteriewTbl = UserInteriewTbl;
    }
    Interview UserInteriewTbl;
    GenericType<Collection<Interview>> UserInterviewGeneric;
    
    
    Collection<Interview> todayInterviewCollection;

    public Collection<Interview> getTodayInterviewCollection() {
        return todayInterviewCollection;
    }

    public void setTodayInterviewCollection(Collection<Interview> todayInterviewCollection) {
        this.todayInterviewCollection = todayInterviewCollection;
    }

    public Interview getTodayInteriewTbl() {
        return todayInteriewTbl;
    }
    
    private String approvedNote;

    public String getApprovedNote() {
        return approvedNote;
    }

    public void setApprovedNote(String approvedNote) {
        this.approvedNote = approvedNote;
    }
    private Interview selectedInterview;
    
    public void prepareForSelection(Interview interview) {
        this.selectedInterview = interview;
    }

    public void saveApprovedNote() {
        // Save the approved note to the selected interview or to the database
        // Example: selectedInterview.setApprovedNote(approvedNote);
    }


    public void setTodayInteriewTbl(Interview todayInteriewTbl) {
        this.todayInteriewTbl = todayInteriewTbl;
    }
    Interview todayInteriewTbl;
    GenericType<Collection<Interview>> todayInterviewGeneric;
    
    @Inject
    private CompanyCdi companyCdi;

    @PostConstruct
    public void init() {
        findInterviewByToday(companyCdi.getLoggedInUser().getUserId());
    }
    
    
    public InterviewCdi() {
        career_Client=new Career_Connect_Client();
        
        interviewCollection=new ArrayList<>();
        interiewTbl=new Interview();
        interviewGeneric=new GenericType<Collection<Interview>>(){};
        
        todayInterviewCollection=new ArrayList<>();
        todayInteriewTbl=new Interview();
        todayInterviewGeneric=new GenericType<Collection<Interview>>(){};
        
        UserInterviewCollection=new ArrayList<>();
        UserInteriewTbl=new Interview();
        UserInterviewGeneric=new GenericType<Collection<Interview>>(){};
        
    }
    
    
     public Collection<Interview> getInterviewCollection() {
        return interviewCollection;
    }

    public void setInterviewCollection(Collection<Interview> interviewCollection) {
        this.interviewCollection = interviewCollection;
    }

    public Interview getInteriewTbl() {
        return interiewTbl;
    }

    public void setInteriewTbl(Interview interiewTbl) {
        this.interiewTbl = interiewTbl;
    }
    
    private String intTime;

    public String getIntTime() {
        return intTime;
    }

    public void setIntTime(String intTime) {
        this.intTime = intTime;
    }
    
    public String ScheduleInterview(){
        try{
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
            int companyId = Integer.parseInt(params.get("companyId"));
            int jobId = Integer.parseInt(params.get("jobId"));
            int userId = Integer.parseInt(params.get("userId"));
            int jobRequestId = Integer.parseInt(params.get("jobRequestId"));
    
            Date interviewDate = interiewTbl.getInterviewDate(); // Initialize interviewDate
            String interviewDateStr = new SimpleDateFormat("yyyy-MM-dd").format(interviewDate);

            career_Client.ScheduleInterview(String.valueOf(companyId), String.valueOf(jobId), 
                    String.valueOf(userId), interiewTbl.getMode(), interviewDateStr, 
                    intTime, interiewTbl.getInterviewDescription());
            
            career_Client.deleteJobRequest(String.valueOf(jobRequestId));
            

        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return "EveryInterview";
        
    }
    
    
    public Date getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }
    
    public void findInterviewByUserId(int id){
        response=career_Client.findInterviewByUserId(Response.class, String.valueOf(id));
        interviewCollection=response.readEntity(interviewGeneric);
    }
    
    public void findInterviewByToday(int id){
        response=career_Client.findInterviewByToday(Response.class,String.valueOf(id));
        todayInterviewCollection=response.readEntity(todayInterviewGeneric);
    }
    
    public String deleteInterview(int id){
        career_Client.deleteInterview(String.valueOf(id));
        return "TodaysInterview?faces-redirect=true";
    }
    
    public void findInterviewByUser(int id){
        response=career_Client.findInterviewByUser(Response.class, String.valueOf(id));
        UserInterviewCollection=response.readEntity(UserInterviewGeneric);
    }
    
        int companyid,userid,jobid;

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    } 
    int interviewId;

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }
    
    public String GotoApprovedPage(Interview inter){
        this.todayInteriewTbl=inter;
        this.companyid=inter.getCompanyId().getUserId();
        this.jobid=inter.getJobId().getJobId();
        this.userid=inter.getUserId().getUserId();
        this.interviewId=inter.getInterviewId();
        
    return "AddApprovedJob";
    }
    
    
    
}
