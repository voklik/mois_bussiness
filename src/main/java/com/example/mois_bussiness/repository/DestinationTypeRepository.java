package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationTypeRepository extends JpaRepository<DestinationType, Long> {

    Optional<DestinationType> findById(Long aLong);

}