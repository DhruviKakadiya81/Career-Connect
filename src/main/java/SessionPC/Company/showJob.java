/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPC.Company;

import EntityPC.Job;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class showJob {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    public Collection<Job> getAllJobs(){
        return entityManager.createNamedQuery("Job.findAll").getResultList();
    }
    
    public Collection<Job> searchJobsByTitle(String title) {
        return entityManager.createNamedQuery("Job.findByJobTitle")
                            .setParameter("jobTitle", title)
                            .getResultList();
    }
    
    
}
