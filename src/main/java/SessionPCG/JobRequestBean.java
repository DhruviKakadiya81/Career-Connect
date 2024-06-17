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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class JobRequestBean {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    public void requestJob(int companyId,int jobId ,int userId , String Message,String Status, Date request_date){
        
        JobRequest request = new JobRequest();
        Job job=entityManager.find(Job.class,jobId);
        UserMaster company=entityManager.find(UserMaster.class, companyId);
        UserMaster user=entityManager.find(UserMaster.class, userId);

        request.setCompanyId(company);
        request.setJobId(job);
        request.setUserId(user);
        request.setMessage(Message);
        request.setStatus(Status);
        request.setRequestedDate(request_date);
        
        entityManager.persist(request);
    }
     
    public void deleteJobRequest(Integer requestId)
    {
        JobRequest deleteJobRequest = entityManager.find(JobRequest.class, requestId); 
        entityManager.remove(deleteJobRequest); 
    }
    
     public Collection<Job> getAllJobRequest(){
        return entityManager.createNamedQuery("JobRequest.findAll").getResultList();
    }
     
     public Collection<JobRequest> findJobRequestsByCompanyIdAndStatus(int companyId, String status) {
         return entityManager.createQuery("SELECT j FROM JobRequest j WHERE j.companyId.userId = :companyId AND j.status = :status",JobRequest.class)
                 .setParameter("companyId", companyId)
                 .setParameter("status", status)
                 .getResultList();
    }
     
     public void ChangeJobRequestStatus(int id,String status){
         JobRequest jobRequest=entityManager.find(JobRequest.class, id);
         jobRequest.setStatus(status);
         entityManager.merge(jobRequest);
     }
     
     public Collection<JobRequest> findJobRequestsByUserId(int userId) {
        return entityManager.createQuery("SELECT jr FROM JobRequest jr WHERE jr.userId.userId = :userId",JobRequest.class)
            .setParameter("userId", userId)
            .getResultList();
    }
}
