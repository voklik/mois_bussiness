package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationTypeRepository extends JpaRepository<DestinationType, Long> {

    DestinationType getById(Long aLong);

}