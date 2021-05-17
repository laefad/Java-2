package com.company.JavaPractice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class    EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${destination}")
    private String destination;

    @Async
    public void sendMail(String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(destination);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
