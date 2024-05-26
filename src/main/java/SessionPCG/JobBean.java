/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.Job;
import EntityPC.JobRequest;
import EntityPC.UserMaster;
import java.util.Collection;
import java.util.Date;
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
    
    @RolesAllowed({"User" , "Admin"})
    public Collection<Job> getAllJobs(){
        return entityManager.createNamedQuery("Job.findAll").getResultList();
    }
    
//    @RolesAllowed("User")
//    public Collection<Job> searchJobsByTitle(String title) {
//        return entityManager.createNamedQuery("Job.findByJobTitle")
//                            .setParameter("jobTitle", title)
//                            .getResultList();
//    }
    
    
    @RolesAllowed("User")
        public Collection<Job> searchJobsByTitle(String title) {
            return entityManager.createQuery("SELECT j FROM Job j WHERE j.jobTitle LIKE :jobTitle")
                                .setParameter("jobTitle", "%" + title + "%")
                                .getResultList();
        }
    
    public void InsertJob(int companyId,String jobTitle,String description,String technology,String qualification,String experience,int salary,String status,String jobType,Date postedDate,Date expirationDate){
        
        Job job=new Job();
        UserMaster userMaster=entityManager.find(UserMaster.class, companyId);
        job.setCompanyId(userMaster);
        job.setJobTitle(jobTitle);
        job.setDescription(description);
        job.setTechnology(technology);
        job.setQualification(qualification);
        job.setExperience(experience);
        job.setSalary(salary);
        job.setStatus(status);
        job.setJobType(jobType);
        job.setPostedDate(postedDate);
        job.setExpirationDate(expirationDate);
                
        entityManager.persist(job);        
    }
    
    public void deleteJob(int jobId) {
    entityManager.createQuery("DELETE FROM Job j WHERE j.jobId = :jobId")
                 .setParameter("jobId", jobId)
                 .executeUpdate();
    }
    
    
    public void updateJob(int jobId,String jobTitle,String description,String technology,String qualification,String experience,int salary,String status,String jobType,Date postedDate,Date expirationDate){
    
        Job job=entityManager.find(Job.class, jobId);
        
        job.setJobTitle(jobTitle);
        job.setDescription(description);
        job.setTechnology(technology);
        job.setQualification(qualification);
        job.setExperience(experience);
        job.setSalary(salary);
        job.setStatus(status);
        job.setJobType(jobType);
        job.setPostedDate(postedDate);
        job.setExpirationDate(expirationDate);
        
        entityManager.merge(job);
    }
    
     
    public Collection<Job> searchJobByCompanyId(int id){
        return entityManager.createQuery("SELECT j FROM Job j WHERE j.companyId.userId = :companyId")
                                .setParameter("companyId", id)
                                .getResultList();
    }
     
    
    
}
