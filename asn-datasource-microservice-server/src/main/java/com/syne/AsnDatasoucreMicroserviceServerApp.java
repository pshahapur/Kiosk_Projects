package com.syne;
/*
 * @author subhajit
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AsnDatasoucreMicroserviceServerApp {
	public static void main(String[] args) {
		SpringApplication.run(AsnDatasoucreMicroserviceServerApp.class, args);
	}
}
