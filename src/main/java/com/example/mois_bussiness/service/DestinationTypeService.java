package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.repository.DestinationRepository;
import com.example.mois_bussiness.repository.DestinationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationTypeService {

    private final DestinationTypeRepository destinationTypeRepository;

    public DestinationType getDestinationType(Long id) {
        return destinationTypeRepository.getById(id);
    }

}
