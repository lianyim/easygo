package com.easygo.test;

import com.easygo.pojo.Users;
import com.easygo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Lym
 * @Date 2020/4/21 15:12
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUsers {

    @Autowired
    UserService userService;

    @Test
    public void test1(){
        Users users = new Users();
        users.setUsername("波波");
        users.setPassword("admin123");
        users.setPhone("12345678912");
        users.setEmail("bobo@163.com");
        users.setNick_name("夜店小王子");
        users.setName("小波波");
        users.setQq("34582654");
        users.setSex("1");
        Integer count = userService.registerUsers(users);
        System.out.println(count>0?"注册成功":"注册失败");
    }

}
