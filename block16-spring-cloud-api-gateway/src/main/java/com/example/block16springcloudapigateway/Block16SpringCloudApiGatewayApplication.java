package com.example.block16springcloudapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Block16SpringCloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block16SpringCloudApiGatewayApplication.class, args);
	}

}
