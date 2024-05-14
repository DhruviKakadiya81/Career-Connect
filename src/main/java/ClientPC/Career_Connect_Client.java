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
    private static final String BASE_URI = "http://localhost:8082/Career_Connect/resources";

    public Career_Connect_Client() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new MyRestFilter());
        webTarget = client.target(BASE_URI).path("rest");
    }

    
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }
    
    
    public void companyRegistration(String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("companyRegistration/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification})).request().post(null);
    }

    public <T> T disUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("disUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T DisplayCompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("DisplayCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void InsertJob(String companyId, String jobTitle, String description, String technology, String qualification, String experience, String salary, String status, String jobType, String postedDate, String expirationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertJob/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{companyId, jobTitle, description, technology, qualification, experience, salary, status, jobType, postedDate, expirationDate})).request().post(null);
    }

    public void updateJob(String jobId, String jobTitle, String description, String technology, String qualification, String experience, String salary, String status, String jobType, String postedDate, String expirationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateJob/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{jobId, jobTitle, description, technology, qualification, experience, salary, status, jobType, postedDate, expirationDate})).request().post(null);
    }

    public void userRegistration(String fname, String lname, String email, String mobile, String profile_img, String birth_date, String addressline, String city, String state, String pincode, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("userRegistration/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{fname, lname, email, mobile, profile_img, birth_date, addressline, city, state, pincode, password})).request().post(null);
    }

    public Response deleteById(String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{userId})).request().delete(Response.class);
    }

    public void updateCompany(String id, String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{id, fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification})).request().post(null);
    }

    public <T> T getAllJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJobs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteJob(String jobId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteJob/{0}", new Object[]{jobId})).request().delete(Response.class);
    }

    public <T> T searchJobsByTitle(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchJobsByTitle/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
