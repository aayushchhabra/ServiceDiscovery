package com.aayush.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SPRING-CLOUD-EUREKA-CLIENT")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String getGreeting();
}
