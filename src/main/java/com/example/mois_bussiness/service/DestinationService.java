package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationTypeService destinationTypeService;
    private final CountryService countryService;

    public List<Destination> getAllUsers() {
        return destinationRepository.findAll();
    }

    public Destination createDestination(String name, String description, boolean isActive, Long countryId, Long destinationTypeId, Address address) {
        Destination destination = new Destination();
        destination.setName(name);
        destination.setActive(isActive);
        destination.setDescription(description);
        destination.setAddress(address);
        Country country = countryService.getCountry(countryId);
        DestinationType destinationType = destinationTypeService.getDestinationType(destinationTypeId);
        destination.setDestinationType(destinationType);

        //try {
           return destinationRepository.save(destination);
        //} catch (Exception e) {

        //}

        //return destination;


    }
}
