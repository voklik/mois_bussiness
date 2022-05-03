package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.dto.mapper.DestinationContactMapper;
import com.example.mois_bussiness.repository.DestinationContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationContactService {

    private final DestinationContactRepository destinationContactRepository;
    private final ContactService contactService;
    private final DestinationService destinationService;
    private final DestinationContactMapper destinationContactMapper;

    public DestinationContact getDestinationContact(Long destinationId) {
        return destinationContactRepository.getById(destinationId);
    }

    public Page<DestinationContactDTO> getAllDestinationContacts(Pageable pageable) {

        Page<DestinationContact> pageDestinationContacts = destinationContactRepository.findAll(pageable);
        List<DestinationContactDTO> destinationContactDTOList = new ArrayList<>();
        List<DestinationContact> destinationContacts = pageDestinationContacts.getContent();
        for (DestinationContact destinationContact : destinationContacts) {
            destinationContactDTOList.add(destinationContactMapper.destinationContactToDTO(destinationContact));
        }
        Page<DestinationContactDTO> pageDestinationsDTO = new PageImpl<>(destinationContactDTOList,
                pageable, destinationContactDTOList.size());

        return pageDestinationsDTO;
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
