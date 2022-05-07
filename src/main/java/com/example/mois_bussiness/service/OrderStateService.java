package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.OrderStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderStateService {

    private final OrderStateRepository orderStateRepository;

    public List<OrderState> getAllOrderStates() {
        return orderStateRepository.findAll();
    }

    public OrderState getOrderState(Long id) {
        Optional<OrderState> orderState = orderStateRepository.findById(id);

        if (orderState.isPresent())
            throw new ObjectNotExistsException("Order state not exists");

        return orderStateRepository.getById(id);
    }
}
