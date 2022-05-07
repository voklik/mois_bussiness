package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.FoodType;
import com.example.mois_bussiness.service.FoodTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/foods")
public class FoodTypeController {

    private final FoodTypeService foodTypeService;

    @GetMapping("")
    public ResponseEntity<List<FoodType>> getAllFoods() {
        List<FoodType> foodTypes = foodTypeService.getAllFoods();
        return ResponseEntity.ok(foodTypes);
    }
}