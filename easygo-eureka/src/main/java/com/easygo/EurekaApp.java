package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Lym
 * @Date 2020/3/27 11:12
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer // 声明这个应用是一个EurekaServer
public class EurekaApp {
    public static void main(String[] args) {
        System.out.println("注册中心9001.... ");
        SpringApplication.run(EurekaApp.class,args);
    }
}
