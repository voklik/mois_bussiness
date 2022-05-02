package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
