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
        webTarget = client.target(BASE_URI).path("rest");
    }

    public <T> T disUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("disUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findByRoleIdAndCompanyName(Class<T> responseType, String roleId, String companyName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByRoleIdAndCompanyName/{0}/{1}", new Object[]{roleId, companyName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteById(String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{userId})).request().delete(Response.class);
    }

    public void updateCompany(String id, String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{id, fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification})).request().post(null);
    }

    public <T> T findByRoleId(Class<T> responseType, String roleId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByRoleId/{0}", new Object[]{roleId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJobs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response login(Object requestEntity) throws ClientErrorException {
        return webTarget.path("login").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T searchJobsByTitle(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchJobsByTitle/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertCompany(String fname, String email, String mobile, String addressline, String city, String state, String pincode, String password, String technology, String specialization, String certification, String roleId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{fname, email, mobile, addressline, city, state, pincode, password, technology, specialization, certification, roleId})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
