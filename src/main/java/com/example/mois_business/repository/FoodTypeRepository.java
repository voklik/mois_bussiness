package com.example.mois_business.repository;

import com.example.mois_business.domain.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
