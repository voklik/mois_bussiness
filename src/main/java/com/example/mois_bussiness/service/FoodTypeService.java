package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.FoodType;
import com.example.mois_bussiness.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodType getFoodType(Long id){
        return foodTypeRepository.getById(id);
    }
}
