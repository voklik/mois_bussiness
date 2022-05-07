package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.DestinationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinationTypeService {

    private final DestinationTypeRepository destinationTypeRepository;

    public DestinationType getDestinationType(Long id) {
        Optional<DestinationType> destinationType = destinationTypeRepository.findById(id);

        if (!destinationType.isPresent())
            throw new ObjectNotExistsException("Destination type not exists");

        return destinationType.get();
    }

    public List<DestinationType> getAllDestinationTypes() {
        return destinationTypeRepository.findAll();
    }

}
