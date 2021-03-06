package com.railway.redis.athena;

import com.railway.redis.RBPSEMSApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RBPSEMSApplication.class)
public class RedisTest {
@Autowired
private JedisCluster jedisCluster;
    private  static final org.slf4j.Logger logger=LoggerFactory.getLogger(RedisTest.class);

@Autowired
private StringRedisTemplate stringRedisTemplate;
@Test
    public void test(){
// 第一步：使用JedisCluster对象。需要一个Set<HostAndPort>参数。Redis节点的列表。
    Set<HostAndPort> nodes = new HashSet<>();
    nodes.add(new HostAndPort("10.83.7.155", 9001));
    nodes.add(new HostAndPort("10.83.7.155", 9002));
    nodes.add(new HostAndPort("10.83.7.155", 9003));
    nodes.add(new HostAndPort("10.83.7.155", 9004));
    nodes.add(new HostAndPort("10.83.7.155", 9005));
    nodes.add(new HostAndPort("10.83.7.155", 9006));
    JedisCluster jedisCluster = new JedisCluster(nodes);
    // 第二步：直接使用JedisCluster对象操作redis。在系统中单例存在。
    jedisCluster.set("hello", "100");
    String result = jedisCluster.get("hello");
    // 第三步：打印结果
    System.out.println("==========================="+result);
    // 第四步：系统关闭前，关闭JedisCluster对象。
    try {
        jedisCluster.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/*@Test
    public void hmset(){
    String[] serverArray = redisProperties.getClusterNodes().split(",");
    Set<HostAndPort> nodes = new HashSet<>();
    for (String ipPort : serverArray) {
        String[] ipPortPair = ipPort.split(":");
        nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
    }
    JedisCluster jedisCluster= new JedisCluster(nodes);
    Boolean name = jedisCluster.exists("name");
    System.out.println("-----------------"+name);
}*/
@Test
    public void test1(){
    Boolean bb=jedisCluster.exists("name");
    logger.debug("8888888888888888888888888888");
    logger.error("9999999999999999999999999999999");
    logger.info("0000000099999999999999997777777777777777777");
    System.out.println("=============="+bb);
}
@Test
    public void testRedis(){
    stringRedisTemplate.opsForValue().set("aa","aaaa");
}


}
