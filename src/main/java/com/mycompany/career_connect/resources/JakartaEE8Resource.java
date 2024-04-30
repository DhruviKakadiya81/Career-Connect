package com.mycompany.career_connect.resources;

import EntityPC.UserMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB
    SessionPC.Login.LoginSession loginSession;
    
    @EJB
    SessionPC.Admin.showCompany showCompany;
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserMaster user) {
        boolean authenticated = loginSession.login(user.getEmail(), user.getPassword());
        if (authenticated) {

            String message = "Your Login successfully Donee!";
            // Print the message to the Postman console
            System.out.println(message);
            // Return a response with the message
            return Response.ok(message).build();
        } else {
            // Invalid credentials
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    
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
    
    @GET
    @Path("findByRoleId/{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMaster> findByRoleId(@PathParam("roleId") int roleId) {
        return showCompany.findByRoleId(roleId);
    }
    
    @DELETE
    @Path("deleteUser/{userId}")
    public Response deleteById(@PathParam("userId") int userId) {
        showCompany.deleteById(userId);
        String message="Deleted Success";
        System.out.println(message);
        return Response.ok(message).build();
    }
}
