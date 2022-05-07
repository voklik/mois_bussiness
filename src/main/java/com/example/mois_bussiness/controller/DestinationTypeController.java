package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.service.DestinationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destination-types")
public class DestinationTypeController {

    private final DestinationTypeService destinationTypeService;

    @GetMapping("")
    public ResponseEntity<List<DestinationType>> getAllDestinationTypes() {
        List<DestinationType> destinationTypes = destinationTypeService.getAllDestinationTypes();
        return ResponseEntity.ok(destinationTypes);
    }
}
