/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CdiPC;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import CdiPC.NewsletterBean2;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NewsletterBeanController {
    @Inject
    private NewsletterBean2 newsletterBean;

    private String subject;
    private String content;

    public void sendNewsletter() {
        newsletterBean.sendNewsletter(subject, content);
         subject = "";
        content = "";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
