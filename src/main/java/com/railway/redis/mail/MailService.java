package com.railway.redis.mail;

/**
 * Created by athena.li on 2018/11/21 9:54
 */
public interface MailService {
     void sendSimpleMail(String to,String subject,String content);
}
