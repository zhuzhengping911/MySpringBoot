package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by zhuzhengping on 2017/3/16.
 * mail test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {


    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void send(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(new String[]{"1111111111@qq.com"});
        simpleMailMessage.setFrom("zhu_zhengping@163.com");
        simpleMailMessage.setSubject("spring boot mail [text]");
        simpleMailMessage.setText(" this is an simple text ");

        mailSender.send(simpleMailMessage);

        System.out.println("mail has been send");
    }
    @Test
    public void sendMail() throws MessagingException {
        Properties properties = new Properties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("zhu_zhengping@hotmail.com","");


            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("zhu_zhengping@hotmail.com"));

        message.setRecipient(Message.RecipientType.TO,new InternetAddress("407993723@qq.com"));

        message.setSubject("123");

        message.setContent("<h1>123:</h1><h3><a href='http://www.google.com'></h3>","text/html;charset=utf-8");

        Transport.send(message);
    }
}
