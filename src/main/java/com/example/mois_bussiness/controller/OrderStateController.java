package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.service.OrderStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/order-states")
public class OrderStateController {

    private final OrderStateService orderStateService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderState> getCountry(@PathVariable Long id) {
        OrderState orderState = orderStateService.getOrderState(id);
        return ResponseEntity.ok(orderState);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderState>> getAllContacts() {
        List<OrderState> orderStates = orderStateService.getAllOrderStates();
        return ResponseEntity.ok(orderStates);
    }
}
