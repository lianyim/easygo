package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lym
 * @Date 2020/3/30 21:22
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProtalWebApp {

    public static void main(String[] args) {
        System.out.println("首页门户9005.... ");
        SpringApplication.run(ProtalWebApp.class,args);
    }

}
