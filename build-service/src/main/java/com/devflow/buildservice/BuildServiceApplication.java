package com.devflow.buildservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuildServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildServiceApplication.class, args);
    }
}