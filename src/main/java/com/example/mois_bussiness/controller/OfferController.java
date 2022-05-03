package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Offer;
import com.example.mois_bussiness.dto.OfferDTO;
import com.example.mois_bussiness.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/offers")
public class OfferController {

    private final OfferService offerService;

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<OfferDTO>> getAllOffers(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size) {
        if (page == null && size == null) {
            page = 1;
            size = 15;
        }
        return new ResponseEntity<>(offerService.getAllOffers(
                PageRequest.of(
                        page, size, Sort.by("dateExpiration").ascending()
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable Long id) {
        Offer offer = offerService.getOffer(id);
        return ResponseEntity.ok(offer);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOffer(@RequestBody @Valid OfferDTO offerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }

        offerService.createOffer(
                offerDTO.getCapacity(),
                offerDTO.getDateAction(),
                offerDTO.getDateExpiration(),
                offerDTO.getDayEnd(),
                offerDTO.getDayStart(),
                offerDTO.getDescription(),
                offerDTO.isActive(),
                offerDTO.getPrice(),
                offerDTO.getCurrencyType().getId(),
                offerDTO.getFoodType().getId(),
                offerDTO.getDestination().getId(),
                offerDTO.getTransportType().getId()
        );

        return ResponseEntity.ok("Offer created"/*new MessageResponse("User registered successfully")*/);
    }
}
