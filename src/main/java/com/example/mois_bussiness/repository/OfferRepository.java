package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
