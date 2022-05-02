package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Offer;
import com.example.mois_bussiness.dto.OfferDTO;
import com.example.mois_bussiness.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/offers")
public class OfferController {

    private final OfferService offerService;

    //TODO mapper a page logika
    @GetMapping("/getAllOffers")
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
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
                offerDTO.getDiscount(),
                offerDTO.getPrice(),
                offerDTO.getCurrencyType().getId(),
                offerDTO.getFoodType().getId(),
                offerDTO.getDestination().getId(),
                offerDTO.getTransportType().getId()
        );

        return ResponseEntity.ok("Offer created"/*new MessageResponse("User registered successfully")*/);
    }
}
