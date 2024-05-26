package com.mycompany.career_connect.resources;

import EntityPC.Job;
import EntityPC.JobRequest;
import EntityPC.Resume;
import EntityPC.UserMaster;
import SessionPCG.UserBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rest")
public class JakartaEE8Resource {
    
    
    @EJB
    SessionPC.Admin.showCompany showCompany;
    
    @EJB
    SessionPCG.UserBean userBean;
    
    @EJB
    SessionPCG.JobBean jobBean;
    
    @EJB
    SessionPCG.JobRequestBean jobRequestBean;
    
    
    @GET
    @Path("disUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response disUser(){
        try {
            Collection<UserMaster> users = showCompany.disUser();
            return Response.ok(users).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
    
  
    @DELETE
    @Path("deleteUser/{userId}")
    public Response deleteById(@PathParam("userId") int userId) {
        showCompany.deleteById(userId);
        String message="Deleted Success";
        System.out.println(message);
        return Response.ok(message).build();
    }
    
    
    @POST
    @Path("updatecompany/{id}/{fname}/{email}/{mobile}/{addressline}/{city}/{state}/{pincode}/{password}/{technology}/{specialization}/{certification}")
    public void updateCompany(
            @PathParam("id") Integer id,
            @PathParam("fname") String fname,
            @PathParam("email") String email,
            @PathParam("mobile") String mobile,
            @PathParam("addressline") String addressline,
            @PathParam("city") String city,
            @PathParam("state") String state,
            @PathParam("pincode") Integer pincode,
            @PathParam("password") String password,
            @PathParam("technology") String technology,
            @PathParam("specialization") String specialization,
            @PathParam("certification") String certification
            ) {

                try {
                    showCompany.updateCompany(id,fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification);

                } catch (PersistenceException e) {

                } catch (RuntimeException e) {

                }
            }
    
    
    @POST
    @Path("userRegistration/{fname}/{lname}/{email}/{mobile}/{profile_img}/{birth_date}/{addressline}/{city}/{state}/{pincode}/{password}")
    public void userRegistration(
            @PathParam("fname") String fname,
            @PathParam("lname") String lname,          
            @PathParam("email") String email,
            @PathParam("mobile") String mobile,
            @PathParam("profile_img") String profile_img,
            @PathParam("birth_date") String birth_date,
            @PathParam("addressline") String addressline,
            @PathParam("city") String city,
            @PathParam("state") String state,
            @PathParam("pincode") Integer pincode,
            @PathParam("password") String password) throws ParseException {

        try {
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date birth=sdf.parse(birth_date);
            
           
            userBean.userRegistration(fname, lname, email, mobile, profile_img, birth, addressline, city, state, pincode, password);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }
    
    
    @POST
    @Path("companyRegistration/{fname}/{email}/{mobile}/{addressline}/{city}/{state}/{pincode}/{password}/{technology}/{specialization}/{certification}")
    public void companyRegistration(
            @PathParam("fname") String fname,
            @PathParam("email") String email,
            @PathParam("mobile") String mobile,
            @PathParam("addressline") String addressline,
            @PathParam("city") String city,
            @PathParam("state") String state,
            @PathParam("pincode") Integer pincode,
            @PathParam("password") String password,
            @PathParam("technology") String technology,
            @PathParam("specialization") String specialization,
            @PathParam("certification") String certification) {

        try {
            userBean.companyRegistration(fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }
    
    
    @GET
    @Path("DisplayCompany")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMaster> DisplayCompany() {
        return userBean.DisplayCompany();
    }
    
    
    @GET
    @Path("searchCompanyByName/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchCompanyByName(@PathParam("title") String title) {
        try {
            Collection<UserMaster> userMasters = userBean.searchCompanyByName(title);
            return Response.ok(userMasters).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("company serached").build();
        }
    }
    
    
    @GET
    @Path("searchCompanyByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchCompanyByEmail(@PathParam("email") String email) {
        try {
            Collection<UserMaster> userMasters = userBean.searchCompanyByEmail(email);
            return Response.ok(userMasters).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
    
    
    @GET
    @Path("searchUserByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchUserByEmail(@PathParam("email") String email) {
        try {
            Collection<UserMaster> userMasters = userBean.searchUserByEmail(email);
            return Response.ok(userMasters).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
    
    
    // Job Methods
    
    
    
    @GET
    @Path("getAllJobs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs(){
        try {
            Collection<Job> jobs = jobBean.getAllJobs();
            return Response.ok(jobs).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Occure").build();
        }
    }
    
    @GET
    @Path("searchJobsByTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchJobsByTitle(@PathParam("title") String title) {
        try {
            Collection<Job> jobs = jobBean.searchJobsByTitle(title);
            return Response.ok(jobs).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
    
    
    @POST
    @Path("InsertJob/{companyId}/{jobTitle}/{description}/{technology}/{qualification}/{experience}/{salary}/{status}/{jobType}/{postedDate}/{expirationDate}")
    public void InsertJob(
            @PathParam("companyId") int companyId,
            @PathParam("jobTitle") String jobTitle,
            @PathParam("description") String description,
            @PathParam("technology") String technology,
            @PathParam("qualification") String qualification,
            @PathParam("experience") String experience,
            @PathParam("salary") Integer salary,
            @PathParam("status") String status,
            @PathParam("jobType") String jobType,
            @PathParam("postedDate") String postedDate,
            @PathParam("expirationDate") String expirationDate) throws ParseException {

        try {
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date postDate=sdf.parse(postedDate);
            Date expDate=sdf.parse(expirationDate);
            
            jobBean.InsertJob(companyId, jobTitle, description, technology, qualification, experience, salary, status, jobType, postDate, expDate);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }
    
    
    @DELETE
    @Path("deleteJob/{jobId}")
    public Response deleteJob(@PathParam("jobId") int jobId) {
        jobBean.deleteJob(jobId);
        String message="Deleted Success";
        System.out.println(message);
        return Response.ok(message).build();
    }
    
    @POST
    @Path("updateJob/{jobId}/{jobTitle}/{description}/{technology}/{qualification}/{experience}/{salary}/{status}/{jobType}/{postedDate}/{expirationDate}")
    public void updateJob(
            @PathParam("jobId") Integer jobId,
            @PathParam("jobTitle") String jobTitle,
            @PathParam("description") String description,
            @PathParam("technology") String technology,
            @PathParam("qualification") String qualification,
            @PathParam("experience") String experience,
            @PathParam("salary") int salary,
            @PathParam("status") String status,
            @PathParam("jobType") String jobType,
            @PathParam("postedDate") String postedDate,
            @PathParam("expirationDate") String expirationDate
            ) throws ParseException {

                try {
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    Date postDate=sdf.parse(postedDate);
                    Date expDate=sdf.parse(expirationDate);
                    jobBean.updateJob(jobId,jobTitle, description,technology, qualification, experience, salary, status, jobType, postDate, expDate);

                } catch (PersistenceException e) {

                } catch (RuntimeException e) {

                }
            }
    
    
    @POST
    @Path("requestJob/{companyid}/{jobid}/{userid}/{message}/{status}/{requetDate}")
     public void requestJob(@PathParam("companyid") int companyId, @PathParam("jobid") int jobId ,@PathParam("userid") int userId ,@PathParam("message") String Message,@PathParam("status") String Status,@PathParam("requetDate") String request_date) throws ParseException{
         
          try {
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date r_date=sdf.parse(request_date);
            
            jobRequestBean.requestJob(companyId, jobId, userId, Message, Status, r_date);
           
        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
         
         
     }
     
      @DELETE
    @Path("deleteJobRequest/{requestId}")
      public void cancleJobRequest(@PathParam("requestId") Integer requestId)
      {
          jobRequestBean.cancleJobRequest(requestId);
      }
        
    @GET
    @Path("getAllJobRequest")
    @Produces(MediaType.APPLICATION_JSON)
     public Collection<Job> getAllJobRequest(){
        return jobRequestBean.getAllJobRequest();
     }      
             
         
    
    @POST
    @Path("uploadResume/{userid}/{pdfname}")
    public void uploadResume(@PathParam("userid") Integer userid ,@PathParam("pdfname") String pdfname)
    {
        userBean.uploadResume(userid, pdfname);
    }
    
    @DELETE
    @Path("deleteResume/{resumeId}")
     public void deleteResume(@PathParam("resumeId") Integer resumeid)
     {
         userBean.deleteResume(resumeid);
     }
     
     @POST
     @Path("displayResume")
      public Collection<Resume> getResume(){
          
           return  userBean.getResume();
      }
      
      
      @GET
      @Path("searchJobByCompanyId/{companyId}")
      @Produces(MediaType.APPLICATION_JSON)
      public Collection<Job> searchJobByCompanyId(@PathParam("companyId") int companyId) {
            return jobBean.searchJobByCompanyId(companyId);
      }
      
      
      @GET
      @Path("findJobRequestsByCompanyIdAndStatus/{companyId}/{status}")
      @Produces(MediaType.APPLICATION_JSON)
      public Collection<JobRequest> findJobRequestsByCompanyIdAndStatus(@PathParam("companyId") int companyId,@PathParam("status") String status) {
            return jobRequestBean.findJobRequestsByCompanyIdAndStatus(companyId,status);
      }
      
      @POST
      @Path("ChangeJobRequestStatus/{id}/{status}")
      public void ChangeJobRequestStatus(@PathParam("id") int id,@PathParam("status") String status){
          jobRequestBean.ChangeJobRequestStatus(id, status);
      }
      
      @GET
      @Path("findJobRequestsByUserId/{userId}")
      @Produces(MediaType.APPLICATION_JSON)
      public Collection<JobRequest> findJobRequestsByUserId(@PathParam("userId") int userId) {
            return jobRequestBean.findJobRequestsByUserId(userId);
      }
      
    
}
