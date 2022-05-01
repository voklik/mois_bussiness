package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.repository.OrderStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStateService {

    private final OrderStateRepository orderStateRepository;

    public List<OrderState> getAllOrderStates() {
        return orderStateRepository.findAll();
    }

    public OrderState getOrderState(Long id) {
        return orderStateRepository.getById(id);
    }
}
