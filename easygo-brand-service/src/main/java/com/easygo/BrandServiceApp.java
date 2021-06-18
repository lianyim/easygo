package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/3/27 10:11
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class BrandServiceApp {

    public static void main(String[] args) {
        System.out.println("品牌服务9000.... ");
        SpringApplication.run(BrandServiceApp.class,args);
    }

}
