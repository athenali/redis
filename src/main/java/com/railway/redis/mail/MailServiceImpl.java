package com.railway.redis.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by athena.li on 2018/11/20 18:02
 */
@Service
public class MailServiceImpl implements  MailService {
/*
@Autowired
    private JavaMailSender javaMailSender;
*/

@Value("${mail.fromMail.addr}")
    private String from;
@Override
public void sendSimpleMail(String to,String subject,String content){
    SimpleMailMessage message=new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);
    try {
       // javaMailSender.send(message);
        System.out.println("邮件已经发送");
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("邮件发送异常");
    }


}
}
