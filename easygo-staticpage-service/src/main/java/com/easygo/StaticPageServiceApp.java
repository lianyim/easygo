package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lym
 * @Date 2020/4/19 22:18
 * @Description 页面静态化服务，不负责连数据库
 * 调用数据库数据，生成静态页面
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class StaticPageServiceApp {

    public static void main(String[] args) {
        System.out.println("静态页面服务9011.... ");
        SpringApplication.run(StaticPageServiceApp.class,args);
    }

}
