package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long> {
}
