/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPC.Admin;

import EntityPC.*;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */

@DeclareRoles({"Admin"})
@Stateless
public class showCompany {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    @RolesAllowed("Admin")
    public Collection<UserMaster> disUser(){
            Collection<UserMaster> user=entityManager.createNamedQuery("UserMaster.findAll").getResultList();
            return user;
    }
    
    
    public Collection<UserMaster> findByRoleId(int roleId) {
        return entityManager.createQuery("SELECT u FROM UserMaster u WHERE u.roleId.roleId = :roleId",UserMaster.class)
                       .setParameter("roleId", roleId)
                       .getResultList();
    }
    
    public void deleteById(int userId) {
    entityManager.createQuery("DELETE FROM UserMaster u WHERE u.userId = :userId")
                 .setParameter("userId", userId)
                 .executeUpdate();
    }
    
    public Collection<UserMaster> findByRoleIdAndCompanyName(int roleId,String companyName) {
    return entityManager.createQuery("SELECT u FROM UserMaster u WHERE u.fName = :fName AND u.roleId.roleId = :roleId")
                       .setParameter("roleId", roleId)
                        .setParameter("fName", "%" + companyName + "%")
                       .getResultList();
    }
    
    
    public void insertCompany(String fname, String email, String mobile, String addressline, String city, String state, Integer pincode, String password, String technology, String specialization, String certification, Integer roleId) {
        UserMaster ut = new UserMaster();
        RoleMaster rt = entityManager.find(RoleMaster.class, roleId);

        ut.setFName(fname);
        ut.setEmail(email);
        ut.setMobileNo(mobile);
        ut.setAddressLine(addressline);
        ut.setCity(city);
        ut.setState(state);
        ut.setPincode(pincode);
        ut.setPassword(password);
        ut.setTechnology(technology);
        ut.setSpecialization(specialization);
        ut.setCertification(certification);
        ut.setRoleId(rt);

        entityManager.persist(ut);
    }

    
    
    
    public void updateCompany(int compId,String fname, String email, String mobile, String addressline, String city, String state, Integer pincode, String password, String technology, String specialization, String certification) {
        UserMaster ut = entityManager.find(UserMaster.class, compId);

        ut.setFName(fname);
        ut.setEmail(email);
        ut.setMobileNo(mobile);
        ut.setAddressLine(addressline);
        ut.setCity(city);
        ut.setState(state);
        ut.setPincode(pincode);
        ut.setPassword(password);
        ut.setTechnology(technology);
        ut.setSpecialization(specialization);
        ut.setCertification(certification);

        entityManager.merge(ut);
    }

    
    
    
}
