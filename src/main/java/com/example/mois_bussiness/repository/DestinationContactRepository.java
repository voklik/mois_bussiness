package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.DestinationContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationContactRepository extends JpaRepository<DestinationContact, Long> {

    DestinationContact getById(Long aLong);

    DestinationContact save(DestinationContact destinationContact);

    List<DestinationContact> findAll(DestinationContact destinationContact);

    DestinationContact findByNameEquals(String name);

}
