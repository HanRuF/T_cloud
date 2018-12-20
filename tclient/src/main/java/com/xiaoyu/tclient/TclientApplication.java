package com.xiaoyu.tclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TclientApplication.class, args);
    }
}
