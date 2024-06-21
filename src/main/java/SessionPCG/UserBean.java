/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.Otp;
import EntityPC.Resume;
import EntityPC.RoleMaster;
import EntityPC.UserMaster;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author HP
 */
@DeclareRoles({"Admin", "User","Company"})
@Stateless
public class UserBean {

    
    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    
    public void userRegistration(String fname,String lname, String email, String mobile,String profile_img,Date birth_date, String addressline, String city, String state, Integer pincode, String password,String resume) {
        UserMaster userMaster = new UserMaster();
        
        Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
        String hashedPassword = passwordHash.generate(password.toCharArray());
       
        userMaster.setFName(fname);
        userMaster.setLName(lname);
        userMaster.setEmail(email);
        userMaster.setMobileNo(mobile);
        userMaster.setProfileImage(profile_img);
        userMaster.setBirthDate(birth_date);
        userMaster.setAddressLine(addressline);
        userMaster.setCity(city);
        userMaster.setState(state);
        userMaster.setPincode(pincode);
        userMaster.setPassword(hashedPassword);
        entityManager.persist(userMaster);
        
        Resume resumetbl=new Resume();
        resumetbl.setUserId(userMaster);
        resumetbl.setPdfName(resume);
        entityManager.persist(resumetbl);
        
        RoleMaster roleMaster=new RoleMaster();
        roleMaster.setEmail(email);
        roleMaster.setGroupname("User");
        entityManager.persist(roleMaster);
        
    }
    
    
    
//    public void userRegistration(String fname,String lname, String email, String mobile,String addressline, String city, String state, Integer pincode, String password) {
//        UserMaster userMaster = new UserMaster();
//        
//        Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
//        String hashedPassword = passwordHash.generate(password.toCharArray());
//       
//        userMaster.setFName(fname);
//        userMaster.setLName(lname);
//        userMaster.setEmail(email);
//        userMaster.setMobileNo(mobile);
////        userMaster.setProfileImage(profile_img);
////        userMaster.setBirthDate(birth_date);
//        userMaster.setAddressLine(addressline);
//        userMaster.setCity(city);
//        userMaster.setState(state);
//        userMaster.setPincode(pincode);
//        userMaster.setPassword(hashedPassword);
//        entityManager.persist(userMaster);
//        
//        RoleMaster roleMaster=new RoleMaster();
//        roleMaster.setEmail(email);
//        roleMaster.setGroupname("User");
//        entityManager.persist(roleMaster);
//        
//    }

    
    
    public void companyRegistration(String fname, String email, String mobile, String addressline, String city, String state, Integer pincode, String password, String technology, String specialization, String certification) {
        UserMaster userMaster = new UserMaster();
        
        Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
        String hashedPassword = passwordHash.generate(password.toCharArray());
       
        userMaster.setFName(fname);
        userMaster.setEmail(email);
        userMaster.setMobileNo(mobile);
        userMaster.setAddressLine(addressline);
        userMaster.setCity(city);
        userMaster.setState(state);
        userMaster.setPincode(pincode);
        userMaster.setPassword(hashedPassword);
        userMaster.setTechnology(technology);
        userMaster.setSpecialization(specialization);
        userMaster.setCertification(certification);
        entityManager.persist(userMaster);
        
        RoleMaster roleMaster=new RoleMaster();
        roleMaster.setEmail(email);
        roleMaster.setGroupname("Company");
        entityManager.persist(roleMaster);
        
    }
    
    @RolesAllowed({"Admin", "User","Company"})
    public Collection<UserMaster> DisplayCompany(){
            return entityManager.createQuery("SELECT u FROM UserMaster u INNER JOIN RoleMaster r ON u.email = r.email WHERE r.groupname = :groupname",UserMaster.class)
                    .setParameter("groupname", "Company")
                    .getResultList();
    }
    
    
    @RolesAllowed("User")
    public Collection<UserMaster> searchCompanyByName(String Name) {
        return entityManager.createQuery("SELECT u FROM UserMaster u INNER JOIN RoleMaster r ON u.email = r.email WHERE u.fName LIKE :firstName AND r.groupname = :groupname")
                            .setParameter("groupname", "Company")
                            .setParameter("firstName", "%" + Name + "%")
                            .getResultList();
    }
    
     public void uploadResume(Integer userid , String pdfname)
    {
        UserMaster userMaster = entityManager.find(UserMaster.class ,userid);
        Resume resumemaster = new Resume();
        
        resumemaster.setUserId(userMaster);
        resumemaster.setPdfName(pdfname);
        
        entityManager.persist(resumemaster);
       
    }
    
     public void deleteResume(Integer resumeid)
    {
       
        Resume deleteResume = entityManager.find(Resume.class, resumeid);
        
        entityManager.remove(deleteResume);
       
    }
     
      public Collection<Resume> getResume(){
        return entityManager.createNamedQuery("Resume.findAll").getResultList();
    }

      public Collection<UserMaster> searchCompanyByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM UserMaster u INNER JOIN RoleMaster r ON u.email = r.email WHERE u.email LIKE :email AND r.groupname = :groupname")
                            .setParameter("groupname", "Company")
                            .setParameter("email", "%" + email + "%")
                            .getResultList();
    }
      
       public Collection<UserMaster> searchUserByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM UserMaster u INNER JOIN RoleMaster r ON u.email = r.email WHERE u.email LIKE :email")
                            .setParameter("email", "%" + email + "%")
                            .getResultList();
    }
       
       
     @Inject
    private EmailPackage.EmailSender emailService;
       
    public Optional<UserMaster> findUserByEmail(String email) {
        try {
            return Optional.ofNullable(entityManager.createNamedQuery("UserMaster.findByEmail", UserMaster.class)
                    .setParameter("email", email)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    
    @Inject
    private HttpSession session;
    
    public void sendOtpIfEmailExists(String email) {
        Optional<UserMaster> userOptional = findUserByEmail(email);
        if (userOptional.isPresent()) {
            String otp = generateOtp();
            emailService.sendOtp(email, otp);
         
            Otp otpEntity = new Otp();
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryDate(new Date(System.currentTimeMillis() + 60 * 1000)); // 1 minute expiry
        entityManager.persist(otpEntity);
           
        }
    }
   
    
    private String generateOtp() {
        // Generate a 6-digit OTP
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }
    
    
    public void resetPassword(String enteredOtp, String newPassword) {
    List<Otp> otps = entityManager.createQuery("SELECT o FROM Otp o WHERE o.otp = :otp AND o.expiryDate > CURRENT_TIMESTAMP", Otp.class)
            .setParameter("otp", enteredOtp)
            .getResultList();

    if (!otps.isEmpty()) {
        Otp otpEntity = otps.get(0);
        String email = otpEntity.getEmail();

        UserMaster user = findUserByEmail(email).orElse(null);
        if (user != null) {
            System.out.println("User found: " + user.getEmail());
            
            Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
        String hashedPassword = passwordHash.generate(newPassword.toCharArray());
        
            user.setPassword(hashedPassword); // Ensure password is hashed
            entityManager.merge(user); // Update the user in the database
            entityManager.remove(otpEntity); // Remove the OTP from the database
            System.out.println("Password updated successfully"); // Debugging line
        } else {
            System.out.println("User not found"); // Debugging line
        }
    } else {
        System.out.println("Invalid or expired OTP"); // Debugging line
        throw new SecurityException("Invalid or expired OTP");
    }
}

    
    public void upateUserProfile(int id,String fname,String lname, String mobile,String Password, String addressline, String state,String city,  Integer pincode){
    
        UserMaster userMaster = entityManager.find(UserMaster.class, id);
       
        Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
        String hashedPassword = passwordHash.generate(Password.toCharArray());
        
        userMaster.setFName(fname);
        userMaster.setLName(lname);
        userMaster.setMobileNo(mobile);
        userMaster.setPassword(hashedPassword);
        userMaster.setAddressLine(addressline);
        userMaster.setState(state);
        userMaster.setCity(city);
        userMaster.setPincode(pincode);
        entityManager.merge(userMaster);
    
    }
    
    
    public void upateCompanyProfile(int id,String fname, String mobile,String Password, String addressline, String state,String city,  Integer pincode,String technology,String specialization,String certification){
    
        UserMaster userMaster = entityManager.find(UserMaster.class, id);
       
        Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
        String hashedPassword = passwordHash.generate(Password.toCharArray());
        
        userMaster.setFName(fname);
        userMaster.setMobileNo(mobile);
        userMaster.setPassword(hashedPassword);
        userMaster.setAddressLine(addressline);
        userMaster.setState(state);
        userMaster.setCity(city);
        userMaster.setPincode(pincode);
        userMaster.setTechnology(technology);
        userMaster.setSpecialization(specialization);
        userMaster.setCertification(certification);
        entityManager.merge(userMaster);
    
    }

    
    
}
