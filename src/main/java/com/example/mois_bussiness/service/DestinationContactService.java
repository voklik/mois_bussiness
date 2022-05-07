package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.exception.InternalErrorException;
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

    public DestinationContact getDestinationContact(Long destinationId) {
        return destinationContactRepository.getById(destinationId);
    }

    public List<DestinationContact> getAllDestinationContacts() {
        return destinationContactRepository.findAll();
    }

    public DestinationContact createDestinationContact(DestinationContactDTO destinationContactDTO) {
        DestinationContact destinationContact = new DestinationContact();
        destinationContact.setValue(destinationContactDTO.getValue());
        Destination destination = destinationService.getDestination(destinationContactDTO.getDestination().getId());
        destinationContact.setDestination(destination);

        try {
            destinationContactRepository.save(destinationContact);
        } catch (Exception e) {
            throw new InternalErrorException("Internal Error");
        }
        return destinationContact;
    }
}
