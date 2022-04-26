package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.service.AddressService;
import com.example.mois_bussiness.service.DestinationService;
import com.example.mois_bussiness.service.DestinationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;
    private final DestinationTypeService destinationTypeService;
    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Object> createDestination(@RequestBody @Valid DestinationDTO destinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }

        Address address = addressService.createAddress(
                destinationDTO.getPostCode(),
                destinationDTO.getCity(),
                destinationDTO.getStreet());

        Destination destination = destinationService.createDestination(
                destinationDTO.getName(),
                destinationDTO.getDescription(),
                destinationDTO.getDestinationTypeId(),
                address);




        return ResponseEntity.ok("Destination created"/*new MessageResponse("User registered successfully")*/);
    }
}
