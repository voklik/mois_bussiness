package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.FoodType;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodType getFoodType(Long id){
        Optional<FoodType> foodType = foodTypeRepository.findById(id);

        if (!foodType.isPresent())
            throw new ObjectNotExistsException("Food type not exists");

        return foodType.get();
    }

    public List<FoodType> getAllFoods() {
        return foodTypeRepository.findAll();
    }
}
