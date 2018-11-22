package com.railway.redis.athena;

import com.railway.redis.RBPSEMSApplication;
import com.railway.redis.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by athena.li on 2018/11/20 18:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RBPSEMSApplication.class)
public class mailTest {
    @Autowired
    private MailService mailService;

    /**
     * 发送一个简单的文本
     */
    @Test
    public void  testSimpleMail(){
        mailService.sendSimpleMail("1159804258@qq.com","标题hello","hello erery one");
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiii");
    }
@Test
    public void sendHtmlMail(){
    String content="<html>\n" +
            "<body>\n" +
            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
            "</body>\n" +
            "</html>";
        mailService.sendHtmlMail("1159804258@qq.com","标题hello html",content);
}

    /**
     * 发送邮件带附件
     */
    @Test
    public void sendAttachmentMail (){
        String filePath="E:\\11.png";
        mailService.sendAttachmentMail("1159804258@qq.com","带附件的邮件","附件，请查收",filePath);
}

@Test
    public void sendLineResourceMail(){
        String rscId="neo006";
    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
    String imgPath = "E:\\11.png";
    mailService.sendLineResourceMail("1159804258@qq.com","静态资源的邮件",content,imgPath,rscId);
}
}
