package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.service.DestinationContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destination-contacts")
public class DestinationContactController {

    private final DestinationContactService destinationContactService;

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<DestinationContactDTO>> getAllDestinations(@PathVariable(required = false) Integer page,
                                                                          @PathVariable(required = false) Integer size) {
        if (page == null && size == null) {
            page = 1;
            size = 15;
        }
        return new ResponseEntity<>(destinationContactService.getAllDestinationContacts(
                PageRequest.of(
                        page, size
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationContact> getDestinationContact(@PathVariable Long id) {
        DestinationContact destinationContact = destinationContactService.getDestinationContact(id);
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
