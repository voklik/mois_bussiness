package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
