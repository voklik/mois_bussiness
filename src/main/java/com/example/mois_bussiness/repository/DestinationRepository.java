package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findAll();

    Destination save(Destination destination);

    Destination getById(Long aLong);
}
