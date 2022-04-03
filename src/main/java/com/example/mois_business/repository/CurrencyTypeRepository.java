package com.example.mois_business.repository;

import com.example.mois_business.domain.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long> {
}
