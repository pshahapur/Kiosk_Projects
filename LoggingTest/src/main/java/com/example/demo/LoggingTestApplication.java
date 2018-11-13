package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.logging.LogTokenScanner;

//@ComponentScan("com.example.logging")
@SpringBootApplication(scanBasePackages="com.example.logging")
public class LoggingTestApplication implements CommandLineRunner{
	
	//@Autowired
	//LogTokenScanner logToken;

	public static void main(String[] args) {
		SpringApplication.run(LoggingTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Boot application");
		String status = new LogTokenScanner().ScanLogger();
		System.out.println("logging status is : " + status);
	}
}
