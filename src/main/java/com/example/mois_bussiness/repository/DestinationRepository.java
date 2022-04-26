package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findAll();

    Destination save(Destination destination);
}
