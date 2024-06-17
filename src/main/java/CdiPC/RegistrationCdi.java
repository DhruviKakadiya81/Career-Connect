package CdiPC;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "registrationCdi")
@RequestScoped
public class RegistrationCdi implements Serializable {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String mobileno;
    private String cpassword;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    
    
    public String register() {
        
      
        if (!password.equals(cpassword)) {
        FacesContext.getCurrentInstance().addMessage("cpassword", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Password and Confirm Password do not match"));
        return null;
    }
    
    
        // Store the values in the session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fname", fname);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lname", lname);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", email);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("password", password);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mobileno", mobileno);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cpassword", cpassword);


        // Redirect to the profile page
          return "profile";
    }
}