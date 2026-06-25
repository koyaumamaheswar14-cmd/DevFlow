package com.devflow.deployservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DeployServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployServiceApplication.class, args);
    }

}
