/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.ApprovedJob;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "adminDashboardCdi")
@RequestScoped
public class AdminDashboardCdi {

    Career_Connect_Client career_Client;
    Response response;

    Collection<ApprovedJob> approvedJobCollection;
    ApprovedJob approvedJobTbl;
    GenericType<Collection<ApprovedJob>> approveJobGeneric;

    public Collection<ApprovedJob> getApprovedJobCollection() {
        response = career_Client.displayApprovedJobs(Response.class);
        approvedJobCollection = response.readEntity(approveJobGeneric);
        return approvedJobCollection;
    }

    public void setApprovedJobCollection(Collection<ApprovedJob> approvedJobCollection) {
        this.approvedJobCollection = approvedJobCollection;
    }

    public ApprovedJob getApprovedJobTbl() {
        return approvedJobTbl;
    }

    public void setApprovedJobTbl(ApprovedJob approvedJobTbl) {
        this.approvedJobTbl = approvedJobTbl;
    }

    public AdminDashboardCdi() {
        career_Client = new Career_Connect_Client();

        approvedJobCollection = new ArrayList<>();
        approvedJobTbl = new ApprovedJob();
        approveJobGeneric = new GenericType<Collection<ApprovedJob>>() {
        };

        fetchUserCount();
    }

    private Integer userCount;
    private Integer cpmpanyCount;
    private Integer jobCount;

    public Integer getCpmpanyCount() {
        return cpmpanyCount;
    }

    public void setCpmpanyCount(Integer cpmpanyCount) {
        this.cpmpanyCount = cpmpanyCount;
    }

    public Integer getJobCount() {
        return jobCount;
    }

    public void setJobCount(Integer jobCount) {
        this.jobCount = jobCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    private void fetchUserCount() {
        try {
            System.out.println("Fetching user count..."); // Debug log
            userCount = career_Client.getUserCount(Integer.class);
            cpmpanyCount = career_Client.getCompanyCount(Integer.class);
            jobCount = career_Client.getTotalJobs(Integer.class);
            System.out.println("Fetched user count: " + userCount); // Debug log
        } catch (Exception e) {
            e.printStackTrace();
            userCount = 0; // Default value in case of an error
            cpmpanyCount = 0;
            jobCount = 0;
        }
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String otp;
    private String newPassword;
    private String confirmPassword;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String GotoHome() {
        return "MainContainer";
    }

    public String GotoReset() {
        career_Client.sendOtpIfEmailExists(email);
        return "ResetPassword";
    }

    public String resetPassword() {
        if (!newPassword.equals(confirmPassword)) {
            // Add a message indicating passwords do not match
            System.out.println("Passwords do not match"); // Debugging line
            return "ForgetPassword";
        }
        try {
            career_Client.resetPassword(otp, newPassword);
            System.out.println("Password reset request sent"); // Debugging line
            return "Login?faces-redirect=true";
        } catch (Exception e) {
            // Add error handling (e.g., invalid OTP)
            System.out.println("Error resetting password: " + e.getMessage()); // Debugging line
            return "ForgetPassword";
        }
    }

}
