/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package CdiPC;

import javax.ejb.Stateless;

import EntityPC.Newsletter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import CdiPC.EmailUtil;

@Stateless
public class NewsletterBean2 {
    @PersistenceContext(unitName = "project_sem8_persistence_unit")
    private EntityManager em;

    public List<Newsletter> getAllNewsletterEmails() {
        return em.createNamedQuery("Newsletter.findAll", Newsletter.class).getResultList();
    }

    public void sendNewsletter(String subject, String content) {
        EmailUtil emailUtil = new EmailUtil();
        List<Newsletter> emails = getAllNewsletterEmails();

        for (Newsletter newsletter : emails) {
            emailUtil.sendEmail(newsletter.getNewsEmail(), subject, content);
        }
        
         subject = null;
    content = null;
    }
}