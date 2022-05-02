package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.repository.DestinationContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationContactService {

    private final DestinationContactRepository destinationContactRepository;
    private final ContactService contactService;
    private final DestinationService destinationService;

    public DestinationContact getDestinationContact(Long id) {
        return destinationContactRepository.getById(id);
    }

    public List<DestinationContact> getAllDestinationContacts() {
        return destinationContactRepository.findAll();
    }

    public DestinationContact createDestinationContact(String value, Long contactId, Long destinationId) {
        DestinationContact destinationContact = new DestinationContact();
        destinationContact.setValue(value);
        Contact contact = contactService.getContact(contactId);
        destinationContact.setContact(contact);
        Destination destination = destinationService.getDestination(destinationId);
        destinationContact.setDestination(destination);

        try {
            destinationContactRepository.save(destinationContact);
        } catch (Exception e) {

        }
        return destinationContact;
    }
}
