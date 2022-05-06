package com.example.emails.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("khalidamairi3@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        message.setTo(toEmail);
        mailSender.send(message);
    }
}
