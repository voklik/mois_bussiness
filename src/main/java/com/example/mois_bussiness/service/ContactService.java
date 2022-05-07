package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.ContactRepository;
import com.example.mois_bussiness.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final DestinationRepository destinationRepository;

    public List<Contact> getContactsByDestination(long destinationId) {
        Optional<Destination> destination = destinationRepository.findById(destinationId);

        if (destination.isPresent())
            throw new ObjectNotExistsException("Destination not exists");

        return contactRepository.findAll(destinationId);

    }

}