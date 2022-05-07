package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country getCountry(Long id) {

        Country country = countryRepository.getById(id);
        if (country == null)
            throw new ObjectNotExistsException("Country not exists");
        return country;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}