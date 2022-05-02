package com.example.mois_bussiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoisBussinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoisBussinessApplication.class, args);
    }

}
