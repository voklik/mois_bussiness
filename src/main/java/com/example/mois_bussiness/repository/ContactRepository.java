package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact getById(Long aLong);

    List<Contact> findAll();

    Contact findByNameEquals(String name);
}
