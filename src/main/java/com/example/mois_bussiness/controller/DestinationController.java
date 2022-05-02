package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.service.AddressService;
import com.example.mois_bussiness.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;
    private final AddressService addressService;

    @GetMapping("/getAllDestinations")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> users = destinationService.getAllDestinations();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createDestination(@RequestBody @Valid DestinationDTO destinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }

        //TODO logika přes mapper

        Address address = addressService.createAddress(
                destinationDTO.getPostCode(),
                destinationDTO.getCity(),
                destinationDTO.getStreet());

        destinationService.createDestination(
                destinationDTO.getName(),
                destinationDTO.getDescription(),
                destinationDTO.isActive(),
                destinationDTO.getCountryId(),
                destinationDTO.getDestinationTypeId(),
                address);

        return ResponseEntity.ok("Destination created"/*new MessageResponse("User registered successfully")*/);
    }
}
