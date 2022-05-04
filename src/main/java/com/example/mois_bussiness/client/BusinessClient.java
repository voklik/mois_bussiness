package com.example.mois_bussiness.client;

import com.example.mois_bussiness.domain.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name= "businessservice", path = "http://localhost:8080/rest/api")
public interface BusinessClient {

    @GetMapping("/countries")
    ResponseEntity<List<Country>> getAllCountries();
}
