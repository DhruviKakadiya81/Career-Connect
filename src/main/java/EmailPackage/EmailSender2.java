/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmailPacakge;

import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP
 */
public class EmailSender2 {
    
     private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587; // or your SMTP port
    private static final String USERNAME = "mansirathod.mscit20@vnsgu.ac.in";
    private static final String PASSWORD = "moay hqwm pxqo pbqs";

    public static void sendEmail(List<String> toAddresses, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));

            // Add recipients
            InternetAddress[] addresses = new InternetAddress[toAddresses.size()];
            for (int i = 0; i < toAddresses.size(); i++) {
                addresses[i] = new InternetAddress(toAddresses.get(i));
            }
            message.setRecipients(Message.RecipientType.TO, addresses);

            message.setSubject(subject);

            // Set the content type to HTML
            message.setContent(body, "text/html; charset=UTF-8");

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}