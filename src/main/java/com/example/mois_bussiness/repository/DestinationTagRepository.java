package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationTagRepository extends JpaRepository<DestinationTag, Long> {

    @Query("FROM Destination d JOIN DestinationTag dt ON d.id = dt.destination.id JOIN Tag t ON t.id = dt.tag.id WHERE t.name = :tagName1 OR t.name = :tagName2 OR (t.name = :tagName1 AND t.name = :tagName2)")
    Page<Destination> findAll(Pageable pageable, String tagName1, String tagName2);
}
