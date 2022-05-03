package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Tag;
import com.example.mois_bussiness.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTag(Long id) {
        return tagRepository.getById(id);
    }
}
