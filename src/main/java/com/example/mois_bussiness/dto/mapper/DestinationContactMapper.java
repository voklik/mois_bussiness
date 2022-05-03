package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.DestinationContact;
import com.example.mois_bussiness.dto.ContactDTO;
import com.example.mois_bussiness.dto.DestinationContactDTO;
import com.example.mois_bussiness.dto.DestinationDTO;
import org.springframework.stereotype.Component;

@Component
public class DestinationContactMapper {

    public DestinationContactDTO destinationContactToDTO(DestinationContact destinationContact) {
        DestinationContactDTO destinationContactDTO = new DestinationContactDTO();
        destinationContactDTO.setId(destinationContact.getId());
        destinationContactDTO.setValue(destinationContact.getValue());

        ContactDTO contact = new ContactDTO();
        contact.setId(destinationContact.getContact().getId());
        contact.setName(destinationContact.getContact().getName());

        destinationContactDTO.setContact(contact);

        DestinationDTO destination = new DestinationDTO();
        destination.setId(destinationContact.getDestination().getId());

        destinationContactDTO.setDestination(destination);

        return destinationContactDTO;
    }
}
