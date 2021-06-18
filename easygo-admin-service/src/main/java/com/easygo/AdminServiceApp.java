package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/3/29 15:42
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class AdminServiceApp {

    public static void main(String[] args) {
        System.out.println("管理员服务9003.... ");
        SpringApplication.run(AdminServiceApp.class,args);
    }
}
