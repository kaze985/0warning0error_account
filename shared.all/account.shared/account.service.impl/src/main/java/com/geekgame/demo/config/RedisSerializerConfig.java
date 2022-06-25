package com.geekgame.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisSerializerConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate redisTemplateInit() {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        RedisSerializer<Object> ser = new GenericJackson2JsonRedisSerializer();

        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(ser);
        redisTemplate.setHashKeySerializer(ser);
        redisTemplate.setHashValueSerializer(ser);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
