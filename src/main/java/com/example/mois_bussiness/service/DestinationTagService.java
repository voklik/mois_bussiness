package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.DestinationTag;
import com.example.mois_bussiness.repository.DestinationTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationTagService {

    private final DestinationTagRepository destinationTagRepository;

    public List<DestinationTag> getAllDestinationTags() {
        return destinationTagRepository.findAll();
    }

    public DestinationTag getDestinationTag(Long id) {
        return destinationTagRepository.getById(id);
    }
}
