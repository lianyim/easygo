package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/4/21 14:57
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApp {

    public static void main(String[] args) {
        System.out.println("会员服务9012.... ");
        SpringApplication.run(UserServiceApp.class,args);
    }

}
