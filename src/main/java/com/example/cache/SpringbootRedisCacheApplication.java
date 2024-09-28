package com.example.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootRedisCacheApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootRedisCacheApplication.class, args);
    }

}
