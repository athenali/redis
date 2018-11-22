package com.railway.redis.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by athena.li on 2018/11/20 18:02
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
             javaMailSender.send(message);
            System.out.println("邮件已经发送");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送异常");
        }


    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper help=new MimeMessageHelper(mimeMessage,true);
            help.setFrom(from);
            help.setTo(to);
            help.setSubject(subject);
            help.setText(content);
            javaMailSender.send(mimeMessage);
            System.out.println("邮件已经发送");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送异常");
        }

    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //true表示要创建一个multipart message
            MimeMessageHelper help=new MimeMessageHelper(mimeMessage,true);
            help.setFrom(from);
            help.setTo(to);
            help.setSubject(subject);
            help.setText(content);
            FileSystemResource file=new FileSystemResource(new File(filePath));
            String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
            help.addAttachment(fileName,file);
            javaMailSender.send(mimeMessage);
            System.out.println("邮件已经发送");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送异常");
        }

    }

    @Override
    public void sendLineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //true表示要创建一个multipart message
            MimeMessageHelper help=new MimeMessageHelper(mimeMessage,true);
            help.setFrom(from);
            help.setTo(to);
            help.setSubject(subject);
            help.setText(content);
            FileSystemResource file=new FileSystemResource(new File(rscPath));
            help.addInline(rscId,file);
            javaMailSender.send(mimeMessage);
            System.out.println("邮件已经发送");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送异常");
        }

    }
}
