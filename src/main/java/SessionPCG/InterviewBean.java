/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionPCG;

import EntityPC.Interview;
import EntityPC.Job;
import EntityPC.UserMaster;
import java.sql.Time;
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
public class InterviewBean {

    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager entityManager;
    
    public Collection<Interview> getAllInterview(){
        return entityManager.createNamedQuery("Interview.findAll").getResultList();
    }
    
    public Collection<Interview> findInterviewByUserId(int userId) {
        return entityManager.createQuery("SELECT i FROM Interview i WHERE i.companyId.userId = :userId",Interview.class)
            .setParameter("userId", userId)
            .getResultList();
    }
    
    public Collection<Interview> findInterviewByToday(int userId) {
        Date today = new Date();

        Date startOfDay = new Date(today.getYear(), today.getMonth(), today.getDate(), 0, 0, 0);

        Date endOfDay = new Date(today.getYear(), today.getMonth(), today.getDate(), 23, 59, 59);
        return entityManager.createQuery("SELECT i FROM Interview i WHERE i.companyId.userId = :userId AND i.interviewDate BETWEEN :startOfDay AND :endOfDay", Interview.class)
            .setParameter("userId", userId)
            .setParameter("startOfDay", startOfDay)
            .setParameter("endOfDay", endOfDay)  
            .getResultList();
    }
    
    public void ScheduleInterview(int companyId,int jobId ,int userId ,String mode,Date interview_date, Time interview_time,String interview_description){
        
        Interview interview = new Interview();
        Job job=entityManager.find(Job.class,jobId);
        UserMaster company=entityManager.find(UserMaster.class, companyId);
        UserMaster user=entityManager.find(UserMaster.class, userId);

        interview.setCompanyId(company);
        interview.setJobId(job);
        interview.setUserId(user);
        interview.setMode(mode);
        interview.setInterviewDate(interview_date);
        interview.setInterviewTime(interview_time);
        interview.setInterviewDescription(interview_description);
        
        entityManager.persist(interview);
    }
    
    
    public void deleteInterview(int id){
        Interview i=entityManager.find(Interview.class, id);
        entityManager.remove(i);
    }
    
    public Collection<Interview> findInterviewByUser(int userId) {
        return entityManager.createQuery("SELECT i FROM Interview i WHERE i.userId.userId = :userId",Interview.class)
            .setParameter("userId", userId)
            .getResultList();
    }
     
}
