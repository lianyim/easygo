package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lym
 * @Date 2020/4/16 21:57
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SearchApp {

    public static void main(String[] args) {
        System.out.println("搜索服务9009.... ");
        SpringApplication.run(SearchApp.class,args);
    }

}
