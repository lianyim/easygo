package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/4/7 9:53
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class ItemServiceApp {

    public static void main(String[] args) {
        System.out.println("品牌服务9008.... ");
        SpringApplication.run(ItemServiceApp.class,args);
    }

}
