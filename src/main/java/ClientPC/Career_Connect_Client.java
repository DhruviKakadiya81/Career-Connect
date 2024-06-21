/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package ClientPC;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:JakartaEE8Resource [rest]<br>
 * USAGE:
 * <pre>
 *        Career_Connect_Client client = new Career_Connect_Client();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author HP
 */
public class Career_Connect_Client {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8082/Career-Connect/resources";

    public Career_Connect_Client() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public <T> T countJobRequestsInMay(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInMay");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInAugust(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInAugust");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T displayApprovedJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("DisplayApprovedJob");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInOctober(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInOctober");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void resetPassword(String otp, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("resetPassword/{0}/{1}", new Object[]{otp, password})).request().post(null);
    }

    public <T> T getTotalJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("totaljobs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCompany(String id, String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{id, fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification})).request().post(null);
    }

    public void sendOtpIfEmailExists(String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("sendOtpIfEmailExists/{0}", new Object[]{email})).request().post(null);
    }

    public void deleteInterview(String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteInterview/{0}", new Object[]{userId})).request().post(null);
    }

    public <T> T getAllJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJobs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteJob(String jobId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteJob/{0}", new Object[]{jobId})).request().delete(Response.class);
    }

    public <T> T disAdminInterview(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("DisplayAdminInterview");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInMarch(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInMarch");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteResume(String resumeId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteResume/{0}", new Object[]{resumeId})).request().delete();
    }

    public <T> T searchJobByCompanyId(Class<T> responseType, String companyId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchJobByCompanyId/{0}", new Object[]{companyId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInFebruary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInFebruary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void requestJob(String companyid, String jobid, String userid, String message, String status, String requetDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("requestJob/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{companyid, jobid, userid, message, status, requetDate})).request().post(null);
    }

    public void companyRegistration(String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("companyRegistration/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification})).request().post(null);
    }

    public <T> T countJobRequestsInJanuary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInJanuary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInApril(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInApril");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInMay(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInMay");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInSeptember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInSeptember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInJuly(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInJuly");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void InsertJob(String companyId, String jobTitle, String description, String technology, String qualification, String experience, String salary, String status, String jobType, String postedDate, String expirationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertJob/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{companyId, jobTitle, description, technology, qualification, experience, salary, status, jobType, postedDate, expirationDate})).request().post(null);
    }

    public <T> T countJobRequestsInFebruary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInFebruary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInFebruary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInFebruary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findJobRequestsByUserId(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findJobRequestsByUserId/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompanyCount(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("totalcompanies");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T disAdminApprovedJob(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("DisplayAdminApprovedJob");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findInterviewByToday(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findInterviewByToday/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteJobRequest(String requestId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteJobRequest/{0}", new Object[]{requestId})).request().delete();
    }

    public <T> T findInterviewByUserId(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findInterviewByUserId/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInNovember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInNovember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchCompanyByName(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchCompanyByName/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteById(String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{userId})).request().delete(Response.class);
    }

    public <T> T countInterviewsInSeptember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInSeptember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findInterviewByUser(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findInterviewByUser/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T DisplayCompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("DisplayCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void ChangeJobRequestStatus(String id, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeJobRequestStatus/{0}/{1}", new Object[]{id, status})).request().post(null);
    }

    public <T> T countInterviewsInJanuary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInJanuary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInMarch(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInMarch");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void userRegistration(String fname, String lname, String email, String mobile, String profile_img, String birth_date, String addressline, String city, String state, String pincode, String password, String resume) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("userRegistration/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{fname, lname, email, mobile, profile_img, birth_date, addressline, city, state, pincode, password, resume})).request().post(null);
    }

    public <T> T getResume(Class<T> responseType) throws ClientErrorException {
        return webTarget.path("displayResume").request().post(null, responseType);
    }

    public <T> T countApprovedJobsInNovember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInNovember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInJuly(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInJuly");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInAugust(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInAugust");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInDecember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInDecember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchJobsByTitle(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchJobsByTitle/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllJobRequest(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJobRequest");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInAugust(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInAugust");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchUserByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchUserByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserCount(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("totalusers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void uploadResume(String userid, String pdfname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("uploadResume/{0}/{1}", new Object[]{userid, pdfname})).request().post(null);
    }

    public <T> T countInterviewsInJuly(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInJuly");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInApril(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInApril");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInMarch(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInMarch");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInMay(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInMay");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInOctober(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInOctober");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T disUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("disUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateJob(String jobId, String jobTitle, String description, String technology, String qualification, String experience, String salary, String status, String jobType, String expirationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateJob/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{jobId, jobTitle, description, technology, qualification, experience, salary, status, jobType, expirationDate})).request().post(null);
    }

    public <T> T countApprovedJobsInDecember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInDecember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countInterviewsInNovember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countInterviewsInNovember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInOctober(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInOctober");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void ScheduleInterview(String companyId, String jobId, String userId, String mode, String interview_date, String interview_time, String interview_description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ScheduleInterview/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{companyId, jobId, userId, mode, interview_date, interview_time, interview_description})).request().post(null);
    }

    public <T> T findJobRequestsByCompanyIdAndStatus(Class<T> responseType, String companyId, String status) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findJobRequestsByCompanyIdAndStatus/{0}/{1}", new Object[]{companyId, status}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInJanuary(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInJanuary");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInApril(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInApril");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInSeptember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInSeptember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findApprovedJobByCompany(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findApprovedJobByCompany/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInDecember(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInDecember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findApprovedJobByUser(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findApprovedJobByUser/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countApprovedJobsInJune(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countApprovedJobsInJune");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countJobRequestsInJune(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countJobRequestsInJune");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void InsertNewsLetterEmail(String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertNews/{0}", new Object[]{email})).request().post(null);
    }

    public <T> T searchCompanyByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchCompanyByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddApprovedJob(String jobRequestId, String companyId, String userId, String jobId, String approved_date, String approval_note, String status, String salary) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddApprovedJob/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{jobRequestId, companyId, userId, jobId, approved_date, approval_note, status, salary})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
