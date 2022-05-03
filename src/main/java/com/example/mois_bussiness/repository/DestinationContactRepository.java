package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.DestinationContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationContactRepository extends JpaRepository<DestinationContact, Long> {

    DestinationContact getByDestinationId(Long id);

    DestinationContact save(DestinationContact destinationContact);

    List<DestinationContact> findAll();

}
