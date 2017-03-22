package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
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
        simpleMailMessage.setTo(new String[]{"zhu_zhengping@hotmail.com"});
        simpleMailMessage.setFrom("407993723@qq.com");
        simpleMailMessage.setSubject("spring boot mail [text]");
        simpleMailMessage.setText(" this is an simple text ");

        mailSender.send(simpleMailMessage);

        System.out.println("mail has been send");
    }
    @Test
    public void sendHtmlMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo("zhu_zhengping@hotmail.com");
        mimeMessageHelper.setFrom("407993723@qq.com");
        mimeMessageHelper.setSubject("mail test【html】");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head></head>");
        stringBuilder.append("<body><h1>spring mail test</h1><p>hello ,this is mail test</p></body>");
        stringBuilder.append("</html>");
        //启用html
        mimeMessageHelper.setText(stringBuilder.toString(),true);
        //发送邮件
        mailSender.send(mimeMessage);

        System.out.println("mail has been send");
    }

    @Test
    public void sendAttachedImageMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo("zhu_zhengping@hotmail.com");
        mimeMessageHelper.setFrom("407993723@qq.com");
        mimeMessageHelper.setSubject("mail test【image】");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head></head>");
        stringBuilder.append("<body><h1>spring mail test</h1><p>hello ,this is mail test</p>");
        stringBuilder.append("<img src=\"cid:imageId\"/></body>");
        stringBuilder.append("</html>");
        //启用html
        mimeMessageHelper.setText(stringBuilder.toString(),true);

        FileSystemResource img = new FileSystemResource(new File("/Users/zhuzhengping/Downloads/IMG_5067.PNG"));
        mimeMessageHelper.addInline("imageId",img);
        //发送邮件
        mailSender.send(mimeMessage);

        System.out.println("mail has been send");
    }
    @Test
    public void sendMail() throws MessagingException {
        Properties properties = new Properties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("zhu_zhengping@hotmail.com","password");


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
