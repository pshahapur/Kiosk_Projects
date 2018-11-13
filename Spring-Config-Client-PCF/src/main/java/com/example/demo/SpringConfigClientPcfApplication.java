package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringConfigClientPcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientPcfApplication.class, args);
	}
}	

@RefreshScope
@RestController
class MessageRestController {

	@Value("${msg:Hello world - Config Server is not working..pelase check}")
	private String msg;

	@RequestMapping("/configmsg")
	String getMsg() {
		return this.msg;
	}
}

