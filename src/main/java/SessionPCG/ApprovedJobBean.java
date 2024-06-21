/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.ApprovedJob;
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
public class ApprovedJobBean {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
     public void AddApprovedJob(int jobRequestId,int companyId,int userId ,int jobId,Date approved_date, String approval_note,String status,int salary){
        
        ApprovedJob approvedJob = new ApprovedJob();
        JobRequest jobRequest=entityManager.find(JobRequest.class, jobRequestId);
        Job job=entityManager.find(Job.class,jobId);
        UserMaster company=entityManager.find(UserMaster.class, companyId);
        UserMaster user=entityManager.find(UserMaster.class, userId);

        approvedJob.setJobRequestId(jobRequest);
        approvedJob.setCompanyId(company);
        approvedJob.setJobId(job);
        approvedJob.setUserId(user);
        approvedJob.setApprovedDate(approved_date);
        approvedJob.setApprovalNote(approval_note);
        approvedJob.setStatus(status);
        approvedJob.setSalary(salary);
        
        entityManager.persist(approvedJob);
    }
     
    public Collection<ApprovedJob> findApprovedJobByCompany(int userId) {
        return entityManager.createQuery("SELECT a FROM ApprovedJob a WHERE a.companyId.userId = :userId",ApprovedJob.class)
            .setParameter("userId", userId)
            .getResultList();
    }
    
    public Collection<ApprovedJob> findApprovedJobByUser(int userId) {
        return entityManager.createQuery("SELECT a FROM ApprovedJob a WHERE a.userId.userId = :userId",ApprovedJob.class)
            .setParameter("userId", userId)
            .getResultList();
    }
    
    public Collection<ApprovedJob> disAdminApprovedJob(){
            Collection<ApprovedJob> approvedJob=entityManager.createNamedQuery("ApprovedJob.findAll").getResultList();
            return approvedJob;
    }
}
