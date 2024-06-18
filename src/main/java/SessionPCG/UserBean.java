/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.Resume;
import EntityPC.RoleMaster;
import EntityPC.UserMaster;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    
    public void userRegistration(String fname,String lname, String email, String mobile,String profile_img,Date birth_date, String addressline, String city, String state, Integer pincode, String password) {
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
    
}
