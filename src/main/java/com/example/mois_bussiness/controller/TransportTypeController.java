package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.TransportType;
import com.example.mois_bussiness.service.TransportTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/transports")
public class TransportTypeController {

    private final TransportTypeService transportTypeService;

    @GetMapping("")
    public ResponseEntity<List<TransportType>> getAllTransportTypes() {
        List<TransportType> transportType = transportTypeService.getAllTransportTypes();
        return ResponseEntity.ok(transportType);
    }
}
