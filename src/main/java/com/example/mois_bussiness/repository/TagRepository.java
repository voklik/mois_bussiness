package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
