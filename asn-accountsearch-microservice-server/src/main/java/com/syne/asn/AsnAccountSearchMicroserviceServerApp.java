package com.syne.asn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.repository.AccountSearchRepository;
import com.syne.asn.repository.RemoteAccountSearchRepository;

/*
 * @author subhajit
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AsnAccountSearchMicroserviceServerApp {

	public static final String DATASOURCE_SERVICE_URL = "http://datasource-microservice";

	public static void main(String[] args) {
		SpringApplication.run(AsnAccountSearchMicroserviceServerApp.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AccountSearchRepository accountSearchRepository() {
		return new RemoteAccountSearchRepository(DATASOURCE_SERVICE_URL);
	}
}
