package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.dto.AddressDTO;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.dto.mapper.DestinationMapper;
import com.example.mois_bussiness.service.DestinationService;
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

    @PostMapping("/")
    public ResponseEntity<Object> createDestination(@RequestBody @Valid DestinationDTO destinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }
        destinationService.createDestination();
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }
}
