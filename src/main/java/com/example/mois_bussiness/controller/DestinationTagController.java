package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.service.DestinationTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destination-tags")
public class DestinationTagController {

    private final DestinationTagService destinationTagService;

    @GetMapping(path = "", params = {"page", "size", "tag1name", "tag2name"})
    public ResponseEntity<Page<Destination>> getAllDestinationTags(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size,
            @RequestParam(name = "tag1name", defaultValue = "") String name1,
            @RequestParam(name = "tag2name", defaultValue = "") String name2) {

        return new ResponseEntity<>(destinationTagService.getDestinationByTags(
                PageRequest.of(page, size)
        , name1, name2), HttpStatus.OK);
    }


}
