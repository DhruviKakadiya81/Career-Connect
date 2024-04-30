/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPC.Login;

import EntityPC.UserMaster;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class LoginSession {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    

     public boolean login(String email, String password) {
        try {
            UserMaster user = entityManager.createNamedQuery("UserMaster.findByEmail", UserMaster.class)
                    .setParameter("email", email)
                    .getSingleResult();
            // Check if the user exists and the password matches
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return false;
    }
   
}
