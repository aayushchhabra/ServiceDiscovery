package com.aayush.eurekafeignclient;

import com.aayush.client.GreetingClient;
import com.netflix.discovery.converters.Auto;
import feign.Feign;
import org.apache.http.annotation.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.aayush"})
@Controller
public class EurekaFeignClientApplication {

	@Autowired
	private GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignClientApplication.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.getGreeting());
		return "greeting-view";
	}

}
