package com.example.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMessage(String email) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setFrom("pelagy.dev@gmail.com");
        mailMessage.setSubject("add new user");
        mailMessage.setText("daroy");

        this.javaMailSender.send(mailMessage);
    }
}
