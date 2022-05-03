package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.service.CurrencyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/currencies")
public class CurrencyController {

    private final CurrencyTypeService currencyTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyType> getCountry(@PathVariable Long id) {
        CurrencyType currencyType = currencyTypeService.getCurrencyType(id);
        return ResponseEntity.ok(currencyType);
    }

    @GetMapping("/")
    public ResponseEntity<List<CurrencyType>> getAllContacts() {
        List<CurrencyType> currencyTypes = currencyTypeService.getAllCurrencies();
        return ResponseEntity.ok(currencyTypes);
    }
}
