package com.example.mois_business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "/com.example.mois_business/domain")
public class MoisBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoisBusinessApplication.class, args);
    }

}
