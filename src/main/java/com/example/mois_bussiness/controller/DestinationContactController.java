package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.service.DestinationContactService;
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
@RequestMapping(path = "rest/api/destinationContacts")
public class DestinationContactController {

    private final DestinationContactService destinationContactService;
    private final DestinationService destinationService;

    @PostMapping("/create")
    public ResponseEntity<Object> createDestinationContact(@RequestBody @Valid DestinationContactDTO destinationContactDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }

        //TODO uvidíme, jak to bude fachat na FE - kdyžtak do ID v service dávat přes celý objekt Destinace

        destinationContactService.createDestinationContact(
                destinationContactDTO.getValue(),
                destinationContactDTO.getContact().getId(),
                destinationContactDTO.getDestination().getId()
        );

        return ResponseEntity.ok("Destination contact created");
    }
}
