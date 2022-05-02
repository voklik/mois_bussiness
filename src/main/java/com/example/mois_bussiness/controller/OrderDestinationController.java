package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.dto.OrderDestinationDTO;
import com.example.mois_bussiness.service.OrderDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/orders")
public class OrderDestinationController {

    private final OrderDestinationService orderDestinationService;

    //TODO logika přes mapper a page
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDestination>> getAllOrders() {
        List<OrderDestination> orderDestinations = orderDestinationService.getAllOrders();
        return ResponseEntity.ok(orderDestinations);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderDestinationDTO orderDestinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }

        orderDestinationService.createOrder(
                orderDestinationDTO.getDateOrder(),
                orderDestinationDTO.getDiscount(),
                orderDestinationDTO.getPrice(),
                orderDestinationDTO.getCurrencyType().getId(),
                orderDestinationDTO.getOrderState().getId(),
                orderDestinationDTO.getOffer().getId(),
                orderDestinationDTO.getUserId()
        );

        return ResponseEntity.ok("Order created"/*new MessageResponse("User registered successfully")*/);
    }
}
