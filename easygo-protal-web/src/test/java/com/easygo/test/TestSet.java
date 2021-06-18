package com.easygo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author Lym
 * @Date 2020/4/10 20:57
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSet {

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.boundSetOps("girls").add("赵丽颖");
        redisTemplate.boundSetOps("girls").add("杨紫");
        redisTemplate.boundSetOps("girls").add("张天爱");
        System.out.println("存值");
    }

    @Test
    public void testValue(){
        Set<Object> girls = redisTemplate.boundSetOps("girls").members();
        for (Object girl : girls) {
            System.out.println(girl);
        }
    }

    @Test
    public void testRemove(){
        redisTemplate.boundSetOps("girls").remove("张天爱");
    }

    @Test
    public void testDelelte(){
        redisTemplate.delete("girls");
    }

}
