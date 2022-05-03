package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.TransportType;
import com.example.mois_bussiness.repository.TransportTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportTypeService {

    private final TransportTypeRepository transportTypeRepository;

    public TransportType getTransportType(Long id) {
        return transportTypeRepository.getById(id);
    }

    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }
}
