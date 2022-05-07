package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("FROM Contact c JOIN DestinationContact d ON c.id = d.contact.id WHERE d.destination.id = :destinationId")
    List<Contact> findAll(long destinationId);

}
