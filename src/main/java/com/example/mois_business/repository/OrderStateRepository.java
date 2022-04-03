package com.example.mois_business.repository;

import com.example.mois_business.domain.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStateRepository extends JpaRepository<OrderState, Long> {
}
