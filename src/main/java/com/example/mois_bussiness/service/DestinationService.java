package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final AddressService addressService;

    public List<Destination> getAllUsers() {
        return destinationRepository.findAll();
    }

    public Destination createDestination () {

        Address address = addressService.createAddress() {

        }

    }
}
