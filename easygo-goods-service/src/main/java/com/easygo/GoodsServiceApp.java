package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/4/17 10:49
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class GoodsServiceApp {
    public static void main(String[] args) {
        System.out.println("Goods服务9010.... ");
        SpringApplication.run(GoodsServiceApp.class,args);
    }
}
