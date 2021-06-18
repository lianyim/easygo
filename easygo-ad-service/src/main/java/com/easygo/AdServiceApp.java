package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/3/30 9:57
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class AdServiceApp {
    public static void main(String[] args) {
        System.out.println("广告服务9003.... ");
        SpringApplication.run(AdServiceApp.class,args);
    }
}
