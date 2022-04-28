package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryDataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCountryData();
    }

    private void loadCountryData() {
        if (countryRepository.count() == 0) {
            Country country1 = new Country( 1l, "Argentina",  "AR", true);
            Country country2 = new Country( 2l, "Poland",  "PL", true);
            Country country3 = new Country( 3l, "China",  "CN", true);
            Country country4 = new Country( 4l, "Bangladesh",  "BD", true);
            Country country5 = new Country( 5l, "Russia",  "RU", true);
            Country country6 = new Country( 6l, "Indonesia",  "ID", true);
            Country country7 = new Country( 7l, "Zimbabwe",  "ZW", true);
            Country country8 = new Country( 8l, "Pakistan",  "PK", true);
            Country country9 = new Country( 9l, "Costa Rica",  "CR", true);
            Country country10 = new Country( 10l, "El Salvador",  "SV", true);
            Country country11 = new Country( 11l, "Benin",  "BJ", true);
            Country country12 = new Country( 12l, "France",  "FR", true);
            Country country13 = new Country( 13l, "Japan",  "JP", true);
            Country country14 = new Country( 14l, "Bulgaria",  "BG", true);
            Country country15 = new Country( 15l, "Czech Republic",  "CZ", true);
            Country country16 = new Country( 16l, "Ireland",  "IE", true);
            Country country17 = new Country( 17l, "Brazil",  "BR", true);
            Country country18 = new Country( 18l, "France",  "FR", true);
            Country country19 = new Country( 19l, "South Africa",  "ZA", true);

            countryRepository.save(country1);
            countryRepository.save(country2);
            countryRepository.save(country3);
            countryRepository.save(country4);
            countryRepository.save(country5);
            countryRepository.save(country6);
            countryRepository.save(country7);
            countryRepository.save(country8);
            countryRepository.save(country9);
            countryRepository.save(country10);
            countryRepository.save(country11);
            countryRepository.save(country12);
            countryRepository.save(country13);
            countryRepository.save(country14);
            countryRepository.save(country15);
            countryRepository.save(country16);
            countryRepository.save(country17);
            countryRepository.save(country18);
            countryRepository.save(country19);
        }
        System.out.println(countryRepository.count());
    }
}
