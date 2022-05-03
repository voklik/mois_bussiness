package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.OrderDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDestinationRepository extends JpaRepository<OrderDestination, Long> {

    List<OrderDestination> getOrdersByUserId(Long userId);
}
