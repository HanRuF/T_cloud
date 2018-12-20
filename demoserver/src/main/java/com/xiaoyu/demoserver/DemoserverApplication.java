package com.xiaoyu.demoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoserverApplication.class, args);
    }
}
