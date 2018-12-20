package com.xiaoyu.tpolice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TpoliceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TpoliceApplication.class, args);
    }
}
