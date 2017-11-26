package com.xteam.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class XTeamEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(XTeamEurekaApplication.class, args);
	}


}
