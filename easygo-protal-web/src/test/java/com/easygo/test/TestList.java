package com.easygo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/10 21:07
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestList {

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 右压栈
     */
    @Test
    public void testListValue(){
        redisTemplate.boundListOps("hobbys").rightPush("美女");
        redisTemplate.boundListOps("hobbys").rightPush("别墅");
        redisTemplate.boundListOps("hobbys").rightPush("豪车");
    }

    @Test
    public void  testGet(){
        List<Object> hobbys = redisTemplate.boundListOps("hobbys").range(0, 10);
        System.out.println(hobbys);
    }

    @Test
    public void testDelete(){
        redisTemplate.boundListOps("hobbys").remove(1,"豪车");
    }

    @Test
    public void testDeleteAll(){
        redisTemplate.delete("hobbys");
    }

}
