package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationTag;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.repository.DestinationTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationTagService {

    private final DestinationTagRepository destinationTagRepository;

    public List<DestinationTag> getAllDestinationTags() {
        return destinationTagRepository.findAll();
    }

    public Page<Destination> getDestinationByTags(Pageable pageable, String tag1Name, String tag2Name) {
        return destinationTagRepository.findAll(pageable,tag1Name, tag2Name);
    }
}
