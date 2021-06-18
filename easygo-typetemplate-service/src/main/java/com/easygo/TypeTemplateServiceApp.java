package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lym
 * @Date 2020/4/5 21:08
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class TypeTemplateServiceApp  {

    public static void main(String[] args) {
        System.out.println("模板服务9007.... ");
        SpringApplication.run(TypeTemplateServiceApp.class,args);
    }

}
