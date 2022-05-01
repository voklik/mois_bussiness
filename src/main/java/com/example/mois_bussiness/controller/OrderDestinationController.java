package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Offer;
import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.dto.OfferDTO;
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

        //TODO logika přes mapper

        return ResponseEntity.ok("Order created"/*new MessageResponse("User registered successfully")*/);
    }
}
