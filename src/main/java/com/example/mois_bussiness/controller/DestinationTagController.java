package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.DestinationTag;
import com.example.mois_bussiness.service.DestinationTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/destination-tags")
public class DestinationTagController {

    private final DestinationTagService destinationTagService;

    @GetMapping("/{}")
    public ResponseEntity<List<DestinationTag>> getAllDestinationTags() {
        List<DestinationTag> destinationTags = destinationTagService.getAllDestinationTags();
        return ResponseEntity.ok(destinationTags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationTag> getDestinationTag(@PathVariable Long id) {
        DestinationTag destinationTag = destinationTagService.getDestinationTag(id);
        return ResponseEntity.ok(destinationTag);
    }
}
