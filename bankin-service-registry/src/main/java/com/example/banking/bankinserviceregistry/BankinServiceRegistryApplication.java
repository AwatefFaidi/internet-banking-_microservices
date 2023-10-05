package com.example.banking.bankinserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class BankinServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankinServiceRegistryApplication.class, args);
	}

}
