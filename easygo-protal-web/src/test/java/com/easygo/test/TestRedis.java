package com.easygo.test;

import com.easygo.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lym
 * @Date 2020/4/10 20:10
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    //操作Redis的核心对象
    @Resource
    private RedisTemplate<String,Object> template;

    /**
     * 新增Redis 并设置Redis的key过期时间
     */
    @Test
    public void testSetValueWithTimeOut(){
        //key的过期时间是10秒钟自动失效
        template.opsForValue().set("message","老司机已上车...",30L, TimeUnit.SECONDS);
        System.out.println("设置完成");
    }

    /**
     * 01-向Redis中存储字符串
     */
    @Test
    public void testSet(){
        System.out.println(template);
        template.opsForValue().set("username1","redis测试1");
        System.out.println("存值成功");
    }

    /**
     * 获取字符串
     */
    @Test
    public void testGet(){
        String username = (String) template.opsForValue().get("username1");
        System.out.println("redis中的值是："+username);
    }

    //存储对象
    @Test
    public void testSetAdmins(){
        Admin admin = new Admin();
        admin.setUsername("小波波");
        admin.setPassword("admin111");
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.opsForValue().set("admin",admin);
        System.out.println("存储成功");
    }

    @Test
    public void testGetAdmins(){
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        Admin admin = (Admin) template.opsForValue().get("admin");
        System.out.println("获取出来："+admin);
    }

    //存储Json
    @Test
    public void testSetAdmin1(){
        Admin admin = new Admin();
        admin.setUsername("小波波");
        admin.setPassword("夜店小王子");
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Admin.class));
        template.opsForValue().set("admin1",admin);
    }

    @Test
    public void testGetAdmin1(){
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Admin.class));
        Admin admin = (Admin) template.opsForValue().get("admin1");
        System.out.println("获取出来："+admin);
    }

}
