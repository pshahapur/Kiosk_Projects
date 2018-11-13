package com.syne.asn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.syne.asn.respository.RegulationRepository;
import com.syne.asn.respository.RemoteRegulationRepository;

/*
 * @author subhajit
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AsnRegulationMicroserviceServerApp {
	public static final String DATASOURCE_SERVICE_URL = "http://datasource-microservice";

	public static void main(String[] args) {
		SpringApplication.run(AsnRegulationMicroserviceServerApp.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RegulationRepository regulationSearchRepository() {
		return new RemoteRegulationRepository(DATASOURCE_SERVICE_URL);
	}
}
