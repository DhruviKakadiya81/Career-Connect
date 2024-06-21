package com.mycompany.career_connect.resources;

import EntityPC.ApprovedJob;
import EntityPC.Interview;
import EntityPC.Job;
import EntityPC.JobRequest;
import EntityPC.Resume;
import EntityPC.UserMaster;
import SessionPCG.UserBean;
import java.sql.Time;
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
import javax.ws.rs.FormParam;
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

    @EJB
    SessionPCG.InterviewBean interviewBean;

    @EJB
    SessionPCG.ApprovedJobBean approvedJobBean;

    @EJB
    SessionPCG.ChartBean chartBean;

    @GET
    @Path("disUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response disUser() {
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
        String message = "Deleted Success";
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
            showCompany.updateCompany(id, fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }

    @POST
    @Path("userRegistration/{fname}/{lname}/{email}/{mobile}/{profile_img}/{birth_date}/{addressline}/{city}/{state}/{pincode}/{password}/{resume}")
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
            @PathParam("password") String password,
            @PathParam("resume") String resume
    ) throws ParseException {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birth = sdf.parse(birth_date);

            userBean.userRegistration(fname, lname, email, mobile, profile_img, birth, addressline, city, state, pincode, password,resume);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }

//    @POST
//    @Path("userRegistration/{fname}/{lname}/{email}/{mobile}/{addressline}/{city}/{state}/{pincode}/{password}")
//    public void userRegistration(
//            @PathParam("fname") String fname,
//            @PathParam("lname") String lname,
//            @PathParam("email") String email,
//            @PathParam("mobile") String mobile,
//            //            @PathParam("profile_img") String profile_img,
//            //            @PathParam("birth_date") String birth_date,
//            @PathParam("addressline") String addressline,
//            @PathParam("city") String city,
//            @PathParam("state") String state,
//            @PathParam("pincode") Integer pincode,
//            @PathParam("password") String password) throws ParseException {
//
//        try {
//
////            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////            Date birth=sdf.parse(birth_date);
//            userBean.userRegistration(fname, lname, email, mobile, addressline, city, state, pincode, password);
//
//        } catch (PersistenceException e) {
//
//        } catch (RuntimeException e) {
//
//        }
//    }
//    
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
    public Response getAllJobs() {
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

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date postDate = sdf.parse(postedDate);
            Date expDate = sdf.parse(expirationDate);

            jobBean.InsertJob(companyId, jobTitle, description, technology, qualification, experience, salary, status, jobType, postDate, expDate);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }

    @DELETE
    @Path("deleteJob/{jobId}")
    public Response deleteJob(@PathParam("jobId") int jobId) {
        jobBean.deleteJob(jobId);
        String message = "Deleted Success";
        System.out.println(message);
        return Response.ok(message).build();
    }

    @POST
    @Path("updateJob/{jobId}/{jobTitle}/{description}/{technology}/{qualification}/{experience}/{salary}/{status}/{jobType}/{expirationDate}")
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
            @PathParam("expirationDate") String expirationDate
    ) throws ParseException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = sdf.parse(expirationDate);
            jobBean.updateJob(jobId, jobTitle, description, technology, qualification, experience, salary, status, jobType, expDate);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }
    }

    @POST
    @Path("requestJob/{companyid}/{jobid}/{userid}/{message}/{status}/{requetDate}")
    public void requestJob(@PathParam("companyid") int companyId, @PathParam("jobid") int jobId, @PathParam("userid") int userId, @PathParam("message") String Message, @PathParam("status") String Status, @PathParam("requetDate") String request_date) throws ParseException {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date r_date = sdf.parse(request_date);

            jobRequestBean.requestJob(companyId, jobId, userId, Message, Status, r_date);

        } catch (PersistenceException e) {

        } catch (RuntimeException e) {

        }

    }

    @DELETE
    @Path("deleteJobRequest/{requestId}")
    public void deleteJobRequest(@PathParam("requestId") Integer requestId) {
        jobRequestBean.deleteJobRequest(requestId);
    }

    @GET
    @Path("getAllJobRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Job> getAllJobRequest() {
        return jobRequestBean.getAllJobRequest();
    }

    @POST
    @Path("uploadResume/{userid}/{pdfname}")
    public void uploadResume(@PathParam("userid") Integer userid, @PathParam("pdfname") String pdfname) {
        userBean.uploadResume(userid, pdfname);
    }

    @DELETE
    @Path("deleteResume/{resumeId}")
    public void deleteResume(@PathParam("resumeId") Integer resumeid) {
        userBean.deleteResume(resumeid);
    }

    @POST
    @Path("displayResume")
    public Collection<Resume> getResume() {

        return userBean.getResume();
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
    public Collection<JobRequest> findJobRequestsByCompanyIdAndStatus(@PathParam("companyId") int companyId, @PathParam("status") String status) {
        return jobRequestBean.findJobRequestsByCompanyIdAndStatus(companyId, status);
    }

    @POST
    @Path("ChangeJobRequestStatus/{id}/{status}")
    public void ChangeJobRequestStatus(@PathParam("id") int id, @PathParam("status") String status) {
        jobRequestBean.ChangeJobRequestStatus(id, status);
    }

    @GET
    @Path("findJobRequestsByUserId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<JobRequest> findJobRequestsByUserId(@PathParam("userId") int userId) {
        return jobRequestBean.findJobRequestsByUserId(userId);
    }

    @POST
    @Path("ScheduleInterview/{companyId}/{jobId}/{userId}/{mode}/{interview_date}/{interview_time}/{interview_description}")
    public void ScheduleInterview(@PathParam("companyId") int companyId, @PathParam("jobId") int jobId, @PathParam("userId") int userId, @PathParam("mode") String mode, @PathParam("interview_date") String interview_date, @PathParam("interview_time") String interview_time, @PathParam("interview_description") String interview_description) throws ParseException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date i_date = sdf.parse(interview_date);
            Time i_time = Time.valueOf(interview_time);
            interviewBean.ScheduleInterview(companyId, jobId, userId, mode, i_date, i_time, interview_description);
        } catch (RuntimeException e) {
        }
    }

    @GET
    @Path("findInterviewByUserId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Interview> findInterviewByUserId(@PathParam("userId") int userId) {
        return interviewBean.findInterviewByUserId(userId);
    }

    @GET
    @Path("findInterviewByToday/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Interview> findInterviewByToday(@PathParam("userId") int userId) {
        return interviewBean.findInterviewByToday(userId);
    }

    @POST
    @Path("deleteInterview/{userId}")
    public void deleteInterview(@PathParam("userId") int userId) {
        interviewBean.deleteInterview(userId);
    }

    @POST
    @Path("AddApprovedJob/{jobRequestId}/{companyId}/{userId}/{jobId}/{approved_date}/{approval_note}/{status}/{salary}")
    public void AddApprovedJob(@PathParam("jobRequestId") int jobRequestId, @PathParam("companyId") int companyId, @PathParam("userId") int userId, @PathParam("jobId") int jobId, @PathParam("approved_date") String approved_date, @PathParam("approval_note") String approval_note, @PathParam("status") String status, @PathParam("salary") int salary) throws ParseException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date app_date = sdf.parse(approved_date);
            approvedJobBean.AddApprovedJob(jobRequestId, companyId, userId, jobId, app_date, approval_note, status, salary);
        } catch (RuntimeException e) {
        }
    }

    @GET
    @Path("findInterviewByUser/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Interview> findInterviewByUser(@PathParam("userId") int userId) {
        return interviewBean.findInterviewByUser(userId);
    }

    @GET
    @Path("findApprovedJobByCompany/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ApprovedJob> findApprovedJobByCompany(@PathParam("userId") int userId) {
        return approvedJobBean.findApprovedJobByCompany(userId);
    }

    @GET
    @Path("findApprovedJobByUser/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ApprovedJob> findApprovedJobByUser(@PathParam("userId") int userId) {
        return approvedJobBean.findApprovedJobByUser(userId);
    }

    @GET
    @Path("countJobRequestsInMay")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInMay() {
        try {
            long count = chartBean.countJobRequestsInMay();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInJanuary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInJanuary() {
        try {
            long count = chartBean.countJobRequestsInJanuary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInFebruary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInFebruary() {
        try {
            long count = chartBean.countJobRequestsInFebruary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInMarch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInMarch() {
        try {
            long count = chartBean.countJobRequestsInMarch();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInApril")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInApril() {
        try {
            long count = chartBean.countJobRequestsInApril();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInJune")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInJune() {
        try {
            long count = chartBean.countJobRequestsInJune();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInJuly")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInJuly() {
        try {
            long count = chartBean.countJobRequestsInJuly();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInAugust")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInAugust() {
        try {
            long count = chartBean.countJobRequestsInAugust();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInSeptember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInSeptember() {
        try {
            long count = chartBean.countJobRequestsInSeptember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInOctober")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInOctober() {
        try {
            long count = chartBean.countJobRequestsInOctober();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInNovember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInNovember() {
        try {
            long count = chartBean.countJobRequestsInNovember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countJobRequestsInDecember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countJobRequestsInDecember() {
        try {
            long count = chartBean.countJobRequestsInDecember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

//    @GET
//    @Path("countInterviewsInJune")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response countInterviewsInJune() {
//        try {
//            long count = userBean.countInterviewsInJune();
//            return Response.ok(count).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
//        }
//    }
    @GET
    @Path("countInterviewsInJanuary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInJanuary() {
        try {
            long count = chartBean.countInterviewsInJanuary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInFebruary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInFebruary() {
        try {
            long count = chartBean.countInterviewsInFebruary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInMarch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInMarch() {
        try {
            long count = chartBean.countInterviewsInMarch();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInApril")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInApril() {
        try {
            long count = chartBean.countInterviewsInApril();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInMay")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInMay() {
        try {
            long count = chartBean.countInterviewsInMay();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInJuly")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInJuly() {
        try {
            long count = chartBean.countInterviewsInJuly();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInAugust")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInAugust() {
        try {
            long count = chartBean.countInterviewsInAugust();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInSeptember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInSeptember() {
        try {
            long count = chartBean.countInterviewsInSeptember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInOctober")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInOctober() {
        try {
            long count = chartBean.countInterviewsInOctober();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInNovember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInNovember() {
        try {
            long count = chartBean.countInterviewsInNovember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countInterviewsInDecember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countInterviewsInDecember() {
        try {
            long count = chartBean.countInterviewsInDecember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInJanuary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInJanuary() {
        try {
            long count = chartBean.countApprovedJobsInJanuary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInFebruary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInFebruary() {
        try {
            long count = chartBean.countApprovedJobsInFebruary();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInMarch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInMarch() {
        try {
            long count = chartBean.countApprovedJobsInMarch();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInApril")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInApril() {
        try {
            long count = chartBean.countApprovedJobsInApril();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInMay")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInMay() {
        try {
            long count = chartBean.countApprovedJobsInMay();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInJune")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInJune() {
        try {
            long count = chartBean.countApprovedJobsInJune();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInJuly")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInJuly() {
        try {
            long count = chartBean.countApprovedJobsInJuly();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInAugust")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInAugust() {
        try {
            long count = chartBean.countApprovedJobsInAugust();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInSeptember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInSeptember() {
        try {
            long count = chartBean.countApprovedJobsInSeptember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInOctober")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInOctober() {
        try {
            long count = chartBean.countApprovedJobsInOctober();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInNovember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInNovember() {
        try {
            long count = chartBean.countApprovedJobsInNovember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("countApprovedJobsInDecember")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countApprovedJobsInDecember() {
        try {
            long count = chartBean.countApprovedJobsInDecember();
            return Response.ok(count).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    @GET
    @Path("/totalusers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCount() {
        long userCount = chartBean.getTotalUsers();
        return Response.ok(userCount).build();
    }

    @GET
    @Path("/totalcompanies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyCount() {
        long companyCount = chartBean.getTotalCompanies();
        return Response.ok(companyCount).build();
    }

    @GET
    @Path("/totaljobs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalJobs() {
        long jobCount = chartBean.getTotalJobs();
        return Response.ok(jobCount).build();
    }

    @GET
    @Path("DisplayApprovedJob")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ApprovedJob> displayApprovedJobs() {
        return chartBean.displayApprovedJobs();
    }

    @POST
    @Path("sendOtpIfEmailExists/{email}")
    public void sendOtpIfEmailExists(@PathParam("email") String email) {
        userBean.sendOtpIfEmailExists(email);
    }

    @POST
    @Path("resetPassword/{otp}/{password}")
    public void resetPassword(@PathParam("otp") String otp, @PathParam("password") String password) {
        System.out.println("Received OTP: " + otp); // Debugging line
    System.out.println("Received Password: " + password); // Debugging line
        userBean.resetPassword(otp, password);
    }
    
    @GET
    @Path("DisplayAdminInterview")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Interview> disAdminInterview() {
        return interviewBean.disAdminInterview();
    }
    
    @GET
    @Path("DisplayAdminApprovedJob")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ApprovedJob> disAdminApprovedJob() {
        return approvedJobBean.disAdminApprovedJob();
    }
    
    @POST
    @Path("InsertNews/{email}")
    public void InsertNewsLetterEmail(@PathParam("email") String email)
    {
        interviewBean.InsertNewsLetterEmail(email);
    }


}
