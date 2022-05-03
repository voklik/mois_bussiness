package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Long id) {
        Country country = countryService.getCountry(id);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/")
    public ResponseEntity<List<Country>> getAllContacts() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}
