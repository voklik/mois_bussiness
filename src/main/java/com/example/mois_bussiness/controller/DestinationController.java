package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.util.ErrorUtil;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.service.AddressService;
import com.example.mois_bussiness.service.ContactService;
import com.example.mois_bussiness.service.DestinationService;
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
@RequestMapping(path = "rest/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;
    private final ContactService contactService;
    private final AddressService addressService;

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<DestinationDTO>> getAllDestinations(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size) {
        if (page == null && size == null) {
            page = 1;
            size = 15;
        }
        return new ResponseEntity<>(destinationService.getAllDestinations(
                PageRequest.of(
                        page, size, Sort.by("name").ascending()
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestination(@PathVariable Long id) {

        Destination destination = destinationService.getDestination(id);
        return ResponseEntity.ok(destination);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createDestination(@RequestBody @Valid DestinationDTO destinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ErrorUtil.getErrorResponse(bindingResult);
        }

        Address address = addressService.createAddress(destinationDTO.getAddress());

        Destination destination = destinationService.createDestination(destinationDTO, address);

        return ResponseEntity.ok(destination);
    }

    @GetMapping("/{id}/contacts}")
    public ResponseEntity<List<Contact>> getDestinationContacts(@PathVariable long id) {

        List<Contact> contact = contactService.getContactsByDestination(id);
        return ResponseEntity.ok(contact);
    }
}
