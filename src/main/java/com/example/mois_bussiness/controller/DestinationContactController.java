package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.service.DestinationContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destination-contacts")
public class DestinationContactController {

    private final DestinationContactService destinationContactService;

    @GetMapping("/")
    public ResponseEntity<List<DestinationContact>> getAllDestinationContacts() {
        List<DestinationContact> destinationContacts = destinationContactService.getAllDestinationContacts();
        return ResponseEntity.ok(destinationContacts);
    }

    @GetMapping("/{destinationId}")
    public ResponseEntity<DestinationContact> getDestinationContact(@PathVariable Long destinationId) {
        DestinationContact destinationContact = destinationContactService.getDestinationContact(destinationId);
        return ResponseEntity.ok(destinationContact);
    }

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
