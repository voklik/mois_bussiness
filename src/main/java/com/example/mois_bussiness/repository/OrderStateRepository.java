package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStateRepository extends JpaRepository<OrderState, Long> {
}
