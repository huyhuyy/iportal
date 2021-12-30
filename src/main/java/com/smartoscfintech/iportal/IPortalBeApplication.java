package com.smartoscfintech.iportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class, CacheAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class
})
public class IPortalBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(IPortalBeApplication.class);
    }
}
