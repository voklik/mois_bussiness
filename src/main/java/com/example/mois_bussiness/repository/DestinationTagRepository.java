package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.DestinationTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationTagRepository extends JpaRepository<DestinationTag, Long> {
}
