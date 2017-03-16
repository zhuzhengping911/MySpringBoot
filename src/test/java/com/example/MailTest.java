package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
