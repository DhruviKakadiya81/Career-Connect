/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.Job;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DeclareRoles({"Admin", "User","Company"})
@Stateless
public class JobBean {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    @RolesAllowed("User")
    public Collection<Job> getAllJobs(){
        return entityManager.createNamedQuery("Job.findAll").getResultList();
    }
    
    @RolesAllowed("User")
    public Collection<Job> searchJobsByTitle(String title) {
        return entityManager.createNamedQuery("Job.findByJobTitle")
                            .setParameter("jobTitle", title)
                            .getResultList();
    }
    
}
