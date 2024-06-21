/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EmailPacakge.EmailSender2;
import EntityPC.ApprovedJob;
import EntityPC.Interview;
import EntityPC.Job;
import EntityPC.Newsletter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.Session;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "adminCdi")
@RequestScoped
public class AdminCdi {

     Career_Connect_Client career_Client;
    
    Response response;
    
    Collection<Job> AdminJobCollection;
    Job AdminJobTbl;
    GenericType<Collection<Job>> AdminJobGeneric;
    
     Collection<Interview> AdminInterviewCollection;
    Interview AdminInterviewTbl;
    GenericType<Collection<Interview>> AdminInterviewGeneric;
    
      Collection<ApprovedJob> AdminApprovedJobCollection;
    ApprovedJob AdminApprovedJobTbl;
    GenericType<Collection<ApprovedJob>> AdminApprovedJobGeneric;
    
    Collection<Newsletter> NewsletterCollection;
    Newsletter NewsletterTbl;
    GenericType<Collection<Newsletter>> NewsletterGeneric;
    
    
    public AdminCdi() {
        
         career_Client=new Career_Connect_Client();
        
        AdminInterviewCollection=new ArrayList<>();
        AdminInterviewTbl=new Interview();
        AdminJobGeneric=new GenericType<Collection<Job>>(){};
        
        AdminJobCollection=new ArrayList<>();
        AdminJobTbl=new Job();
        AdminInterviewGeneric=new GenericType<Collection<Interview>>(){};
        
          AdminApprovedJobCollection=new ArrayList<>();
        AdminApprovedJobTbl=new ApprovedJob();
        AdminApprovedJobGeneric=new GenericType<Collection<ApprovedJob>>(){};
        
          NewsletterCollection=new ArrayList<>();
        NewsletterTbl=new Newsletter();
        NewsletterGeneric=new GenericType<Collection<Newsletter>>(){};
        
          
        
        
    }
    
     private Date currentDate;

    @PostConstruct
    public void init() {
        currentDate = new Date();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public Collection<Job> getAdminJobCollection() {
            response = career_Client.getAllJobs(Response.class);
            AdminJobCollection= response.readEntity(AdminJobGeneric);
            return AdminJobCollection;
    }

    public void setAdminJobCollection(Collection<Job> AdminJobCollection) {
        this.AdminJobCollection = AdminJobCollection;
    }

    public Job getAdminJobTbl() {
        return AdminJobTbl;
    }

    public void setAdminJobTbl(Job AdminJobTbl) {
        this.AdminJobTbl = AdminJobTbl;
    }

    public Collection<Interview> getAdminInterviewCollection() {
        response = career_Client.disAdminInterview(Response.class);
            AdminInterviewCollection= response.readEntity(AdminInterviewGeneric);
        return AdminInterviewCollection;
    }

    public void setAdminInterviewCollection(Collection<Interview> AdminInterviewCollection) {
        this.AdminInterviewCollection = AdminInterviewCollection;
    }

    public Collection<ApprovedJob> getAdminApprovedJobCollection() {
          response = career_Client.displayApprovedJobs(Response.class);
          AdminApprovedJobCollection= response.readEntity(AdminApprovedJobGeneric);
          return AdminApprovedJobCollection;
    }

    public void setAdminApprovedJobCollection(Collection<ApprovedJob> AdminApprovedJobCollection) {
        this.AdminApprovedJobCollection = AdminApprovedJobCollection;
    }

    public ApprovedJob getAdminApprovedJobTbl() {
        return AdminApprovedJobTbl;
    }

    public void setAdminApprovedJobTbl(ApprovedJob AdminApprovedJobTbl) {
        this.AdminApprovedJobTbl = AdminApprovedJobTbl;
    }
    
    

    public Interview getAdminInterviewTbl() {
        return AdminInterviewTbl;
    }

    public void setAdminInterviewTbl(Interview AdminInterviewTbl) {
        this.AdminInterviewTbl = AdminInterviewTbl;
    }

    public Collection<Newsletter> getNewsletterCollection() {
        return NewsletterCollection;
    }

    public void setNewsletterCollection(Collection<Newsletter> NewsletterCollection) {
        this.NewsletterCollection = NewsletterCollection;
    }

    public Newsletter getNewsletterTbl() {
        return NewsletterTbl;
    }

    public void setNewsletterTbl(Newsletter NewsletterTbl) {
        this.NewsletterTbl = NewsletterTbl;
    }
    
    
    
    public void InsertNewsLetterEmail()
    {
        career_Client.InsertNewsLetterEmail(NewsletterTbl.getNewsEmail());
    }

    
    
//     public void newsRecive() {
//    try {
//        career_Client.NewsRecive(NewsreceiveTbl.getNewsSubject(), NewsreceiveTbl.getNewsMsg());
//        
//        List<String> toAddresses = new ArrayList<>(); // Create a list to store email addresses
//    toAddresses.add(NewsletterTbl.getNewsEmail()); // Add the user's email address
//
//    // Retrieve all email addresses from the table
////    List<Newsletter> allUsers = getAllUsersFromTable(); // Replace with your method to retrieve all users
//
////    for (Newsletter user : allUsers) {
////        toAddresses.add(user.getNewsEmail()); // Add each user's email address to the list
////    }
//
//    String subject = "New User Registration";
//    String body = "<html><body style='font-family: Arial, sans-serif; color: #333;'>" +
//            "<p>A new user has been registered with the following details:</p>" +
//            "<ul>" +
//            "<li>Username: <span style='color: #095c9d;'>" + NewsreceiveTbl.getNewsMsg()+ "</span></li>" +
//            "<li>Password: <span style='color: #095c9d;'>" + NewsreceiveTbl.getNewsSubject()+ "</span></li>" +
//            "</ul>" +
//            "<p>Best regards,</p>" +
//            "<p>The Career-Connect Team</p>" +
//            "<p>Career-Connect<br>" +
//            "Connecting Talent with Opportunities<br>" +
//            "<a href='www.career-connect.com' style='color: #095c9d;'>www.career-connect.com</a></p>" +
//            "</body></html>"; // Note: Sending passwords via email is not recommended in production
//
//    EmailSender2.sendEmail(toAddresses, subject, body); // Pass the list of email addresses
//
//
//        
//    } catch (Exception e) {
//        // Handle any exceptions that may occur
//        e.printStackTrace();
//    }
//    
//    
//}
    
    
    
    
//     private List<Newsletter> getAllUsersFromTable() {
//    // Replace with your implementation to retrieve all users from the table
//    // For example, using Hibernate:
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    session.beginTransaction();
//    List<Newsletter> allUsers = session.createQuery("from UserTbl").list();
//    session.getTransaction().commit();
//    return allUsers;
//}
    
    
    
    
}