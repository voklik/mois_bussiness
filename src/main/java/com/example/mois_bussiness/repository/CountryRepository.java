package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country getById(Long aLong);
}
