package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/4/1 17:13
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class SpecificationServiceApp {

    public static void main(String[] args) {
        System.out.println("规格服务9006.... ");
        SpringApplication.run(SpecificationServiceApp.class,args);
    }

}
