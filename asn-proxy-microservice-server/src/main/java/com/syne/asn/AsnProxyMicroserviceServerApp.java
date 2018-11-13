package com.syne.asn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * @author subhajit
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class AsnProxyMicroserviceServerApp {
	public static void main(String[] args) {
		SpringApplication.run(AsnProxyMicroserviceServerApp.class, args);
	}
}
