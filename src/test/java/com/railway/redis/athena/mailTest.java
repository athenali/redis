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

    @Test
    public void  testSimpleMail(){
        mailService.sendSimpleMail("1159804258@qq.com","标题hello","hello erery one");
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiii");
        
    }
}
