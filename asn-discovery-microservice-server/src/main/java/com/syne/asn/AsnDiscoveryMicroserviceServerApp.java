package com.syne.asn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * @author subhajit
 */
@SpringBootApplication
@EnableEurekaServer
public class AsnDiscoveryMicroserviceServerApp {

	public static void main(String[] args) {
		SpringApplication.run(AsnDiscoveryMicroserviceServerApp.class, args);
	}
}
