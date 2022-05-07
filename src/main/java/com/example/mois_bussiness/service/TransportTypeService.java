package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.TransportType;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.TransportTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransportTypeService {

    private final TransportTypeRepository transportTypeRepository;

    public TransportType getTransportType(Long id) {
        Optional<TransportType> transportType = transportTypeRepository.findById(id);

        if (!transportType.isPresent())
            throw new ObjectNotExistsException("Transport type not exists");

        return transportType.get();
    }

    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }
}
