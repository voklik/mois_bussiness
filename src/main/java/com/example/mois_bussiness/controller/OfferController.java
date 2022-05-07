package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Offer;
import com.example.mois_bussiness.domain.util.ErrorUtil;
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

    @GetMapping(path = "", params = {"page", "size", "sortBy", "sortAsc"})
    public ResponseEntity<Page<OfferDTO>> getAllOffers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size,
            @RequestParam(name = "sortBy", defaultValue = "dateExpiration") String sortBy,
            @RequestParam(name = "sortAsc", defaultValue = "true") boolean sortAsc) {

        Sort sort = Sort.by(sortBy).ascending();
        if (!sortAsc)
            sort = sort.descending();

        return new ResponseEntity<>(offerService.getAllOffers(
                PageRequest.of(page, size, sort)
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
            return ErrorUtil.getErrorResponse(bindingResult);
        }

        Offer offer = offerService.createOffer(offerDTO);

        return ResponseEntity.ok(offer);
    }
}
