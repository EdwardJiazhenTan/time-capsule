package com.edwardjtan.timecapsule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // automatically create a javamailsender with springboot
    private final JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Send email with text
     * @params to target Address
     * @param subject subject of the Email
     * @param text the body of email
     */
    public void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            System.out.println("Attempt tp send email to : " + to);
            mailSender.send(message);
            System.out.println("send successful");
        } catch (Exception e) {
            System.err.println(
                "Error sending email to " + to + ": " + e.getMessage()
            );
            e.printStackTrace();
        }
    }
}
