package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.dto.mapper.DestinationMapper;
import com.example.mois_bussiness.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationTypeService destinationTypeService;
    private final CountryService countryService;
    private final DestinationMapper destinationMapper;

    public Page<DestinationDTO> getAllDestinations(Pageable pageable) {

        Page<Destination> pageDestinations =  destinationRepository.findAll(pageable);
        List<DestinationDTO> destinationDTOList = new ArrayList<>();
        List<Destination>  destinations = pageDestinations.getContent();
        for(Destination destination : destinations) {
            destinationDTOList.add(destinationMapper.destinationToDTO(destination));
        }
        Page<DestinationDTO> pageDestinationsDTO = new PageImpl<>(destinationDTOList, pageable, destinationDTOList.size());

        return pageDestinationsDTO;
    }

    public Destination getDestination(Long id) {
        return destinationRepository.getById(id);
    }

    public Destination createDestination(String name, String description, boolean isActive, Long countryId, Long destinationTypeId, Address address) {
        Destination destination = new Destination();
        destination.setName(name);
        destination.setActive(isActive);
        destination.setDescription(description);
        destination.setAddress(address);
        Country country = countryService.getCountry(countryId);
        destination.setCountry(country);
        DestinationType destinationType = destinationTypeService.getDestinationType(destinationTypeId);
        destination.setDestinationType(destinationType);

        try {
            destinationRepository.save(destination);
        } catch (Exception e) {
        }

        return destination;
    }
}
