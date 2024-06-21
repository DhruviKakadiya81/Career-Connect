/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EmailPackage.EmailSender;
import EntityPC.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "companyCdi")
@RequestScoped
public class CompanyCdi {

    Career_Connect_Client career_Client;

    Response response;

    Collection<UserMaster> userCollection;
    UserMaster userTbl;
    GenericType<Collection<UserMaster>> userGeneric;

    String searchCompany;
    private int selectedCompanyId;

    public int getSelectedCompanyId() {
        return selectedCompanyId;
    }

    public void setSelectedCompanyId(int selectedCompanyId) {
        this.selectedCompanyId = selectedCompanyId;
    }

    public CompanyCdi() {
        career_Client = new Career_Connect_Client();

        userCollection = new ArrayList<>();
        userTbl = new UserMaster();
        userGeneric = new GenericType<Collection<UserMaster>>() {
        };
    }

    public Collection<UserMaster> getUserCollection() {
        if (searchCompany != null) {
            response = career_Client.searchCompanyByName(Response.class, searchCompany);
            userCollection = response.readEntity(userGeneric);
            return userCollection;
        } else {
            response = career_Client.DisplayCompany(Response.class);
            userCollection = response.readEntity(userGeneric);
            return userCollection;
        }

    }

    public void setUserCollection(Collection<UserMaster> userCollection) {
        this.userCollection = userCollection;
    }

    public UserMaster getUserTbl() {
        return userTbl;
    }

    public void setUserTbl(UserMaster userTbl) {
        this.userTbl = userTbl;
    }

    public String deleteCompany(int id) {
        career_Client.deleteById(String.valueOf(id));
        return "DisplayCompany";
    }

    public String getCompany(UserMaster u) {
        this.userTbl = u;
        return "UpdateCompany";
    }

    public String getSearchCompany() {
        return searchCompany;
    }

    public void setSearchCompany(String searchCompany) {
        this.searchCompany = searchCompany;
    }

    public String updateCompany() {
        career_Client.updateCompany(String.valueOf(userTbl.getUserId()), userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification());
        return "DisplayCompany";
    }

    public String companyRegistration() {
        career_Client.companyRegistration(userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification());
//        career_Client.insertCompany(userTbl.getFName(), userTbl.getEmail(), userTbl.getMobileNo(), userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), userTbl.getPassword(), userTbl.getTechnology(), userTbl.getSpecialization(), userTbl.getCertification(),String.valueOf(3));
        String toAddress = userTbl.getEmail(); // Replace with recipient email address
        String subject = "New User Registration";
        String body = "<html><body style='font-family: Arial, sans-serif; color: #333;'>"
                + "<p>A new user has been registered with the following details:</p>"
                + "<ul>"
                + "<li>Username: <span style='color: #095c9d;'>" + userTbl.getEmail() + "</span></li>"
                + "<li>Password: <span style='color: #095c9d;'>" + userTbl.getPassword() + "</span></li>"
                + "</ul>"
                + "<p>Best regards,</p>"
                + "<p>The Career-Connect Team</p>"
                + "<p>Career-Connect<br>"
                + "Connecting Talent with Opportunities<br>"
                + "<a href='www.career-connect.com' style='color: #095c9d;'>www.career-connect.com</a></p>"
                + "</body></html>"; // Note: Sending passwords via email is not recommended in production
        EmailSender.sendEmail(toAddress, subject, body);

        return "DisplayCompany";
    }

    public String searchCompanyUsingName() {
        return "DisplayCompany";
    }

    public String GotoInsert() {
        return "InsertCompany";
    }

    public void viewJobs(int companyId) {
        this.selectedCompanyId = companyId;
        FacesContext fc = FacesContext.getCurrentInstance();
        NavigationHandler nh = fc.getApplication().getNavigationHandler();
        nh.handleNavigation(fc, null, "DisplayJob?faces-redirect=true&companyId=" + companyId);
    }

//    @PostConstruct
//    public void init() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        if (session != null) {
//            loggedInUser = (String) session.getAttribute("loggedInUser");
//        }
//    }
    private UserMaster loggedInUser;

    public UserMaster getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserMaster loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    private String getLoggedInUserEmail() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (String) session.getAttribute("loggedInUser");  // Assuming userEmail is stored in session
    }

    @PostConstruct
    public void init() {
        String loggedInUserEmail = getLoggedInUserEmail();
        System.out.println("Logged in user email: " + loggedInUserEmail);
        if (loggedInUserEmail != null) {
            response = career_Client.searchUserByEmail(Response.class, loggedInUserEmail);
            Collection<UserMaster> users = response.readEntity(new GenericType<Collection<UserMaster>>() {
            });
            System.out.println("Fetched users: " + users);
            if (!users.isEmpty()) {
                loggedInUser = users.iterator().next();
            }
        }
    }
}
