package com.devglan.eurekaservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/secondapp")
    public String greeting(){
        return "Hello from Spring Boot Cloud test" ;
    }


}
