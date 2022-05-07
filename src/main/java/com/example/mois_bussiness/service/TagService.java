package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Tag;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTag(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isPresent())
            throw new ObjectNotExistsException("Tag not exists");
        return tag.get();
    }
}
