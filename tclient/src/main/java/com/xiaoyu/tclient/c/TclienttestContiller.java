package com.xiaoyu.tclient.c;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;

@RestController
@Configuration
public class TclienttestContiller {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @RequestMapping("/c")
    @ResponseBody
    public String vi(){
        return "dddd";
    }

    @RequestMapping("/vbn")
    @ResponseBody
    public String router(){
      RestTemplate restTemplate=getRestTemplate();
      System.out.println("调用");
      String json=restTemplate.getForObject("http://eurake-tpolice/home",String.class);
      return json;
    }

    @RequestMapping(value="/view",produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Object view(){
        RestTemplate restTemplate=getRestTemplate();
        System.out.println("调用view");
        Object json=restTemplate.getForObject("http://eurake-tpolice/view",Object.class);
        return json;
    }
}
