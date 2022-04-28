package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.FoodType;
import com.example.mois_bussiness.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodTypeDataLoader implements CommandLineRunner {

    private final FoodTypeRepository foodTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadFoodTypeData();
    }

    private void loadFoodTypeData() {
        if (foodTypeRepository.count() == 0) {
            FoodType foodType1 = new FoodType( 1l, "Bez stravování", true);
            FoodType foodType2 = new FoodType( 2l, "Plná penze", true);
            FoodType foodType3 = new FoodType( 3l, "Polopenze", true);

            foodTypeRepository.save(foodType1);
            foodTypeRepository.save(foodType2);
            foodTypeRepository.save(foodType3);
        }
        System.out.println(foodTypeRepository.count());
    }
}
