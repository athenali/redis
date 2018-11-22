package com.railway.redis.athena;

import com.railway.redis.RBPSEMSApplication;
import com.railway.redis.entity.User;
import com.railway.redis.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by athena.li on 2018/11/21 13:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RBPSEMSApplication.class)
public class druidTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void test(){
        /**
         * 通过在配置文件中添加druid,可以在控制台中看到
         * DruidDataSource
         * 说明springboot已经把druid当做DataSource加载到项目中
         */
        List<User> all = userRepository.findAll();
        System.out.println("================"+all.size());
    }

    /**
     * 开启Druid监控
     */
    @Test
    public void beginDruid(){

    }
}
