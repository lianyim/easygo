package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lym
 * @Date 2020/3/27 14:27
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AdminWebApp {
    public static void main(String[] args) {
        System.out.println("运营商界面web9002.... ");
        SpringApplication.run(AdminWebApp.class,args);
    }
}
