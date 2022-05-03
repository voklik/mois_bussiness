package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.dto.OrderDestinationDTO;
import com.example.mois_bussiness.service.OrderDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<OrderDestinationDTO>> getAllOrders(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size) {
        if (page == null && size == null) {
            page = 1;
            size = 15;
        }
        return new ResponseEntity<>(orderDestinationService.getAllOrders(
                PageRequest.of(
                        page, size, Sort.by("dateOrder").ascending()
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDestination>> getDestinationByUser(@PathVariable Long userId) {
        List<OrderDestination> orderDestinationByUser = orderDestinationService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orderDestinationByUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDestination> getDestination(@PathVariable Long id) {
        OrderDestination orderDestination = orderDestinationService.getOrderDestination(id);
        return ResponseEntity.ok(orderDestination);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderDestinationDTO orderDestinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }

        orderDestinationService.createOrder(
                orderDestinationDTO.getDateOrder(),
                orderDestinationDTO.getPrice(),
                orderDestinationDTO.getCurrencyType().getId(),
                orderDestinationDTO.getOrderState().getId(),
                orderDestinationDTO.getOffer().getId(),
                orderDestinationDTO.getUserId()
        );

        return ResponseEntity.ok("Order created"/*new MessageResponse("User registered successfully")*/);
    }
}
