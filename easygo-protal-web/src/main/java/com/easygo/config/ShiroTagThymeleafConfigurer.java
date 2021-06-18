package com.easygo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
/**
 * @Author Lym
 * @Date 2020/4/23 10:49
 * @Description 集成Shiro标签，Thymeleaf中可以使用Shiro标签来完成权限控制
 */
@SpringBootConfiguration
public class ShiroTagThymeleafConfigurer {

    /**
     * 配置方言
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
