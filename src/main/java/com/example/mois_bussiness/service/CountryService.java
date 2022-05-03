package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country getCountry(Long id) {
        return countryRepository.getById(id);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
