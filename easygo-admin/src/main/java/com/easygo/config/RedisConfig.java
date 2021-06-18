package com.easygo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author Lym
 * @Date 2020/4/10 11:45
 * @Description  SpringBoot整合SpringData Redis
 */
@Configuration
public class RedisConfig {

    /**
     * 01-负责配置文件和连接池
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        System.out.println("最大空闲数："+config.getMaxIdle());
        System.out.println("最小空闲数："+config.getMinIdle());
        System.out.println("最大连接数："+config.getMaxTotal());
        return config;
    }

    /**
     * 02-连接工厂
     * @param config
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
        JedisConnectionFactory factory=new JedisConnectionFactory();
        factory.setPoolConfig(config);
        return factory;
    }

    /**
     * Redis操作和RedisTemplate对象
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String,Object> template=new RedisTemplate<String,Object>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化器
        template.setHashKeySerializer(new StringRedisSerializer());
        //为value设置序列化器
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }


}
