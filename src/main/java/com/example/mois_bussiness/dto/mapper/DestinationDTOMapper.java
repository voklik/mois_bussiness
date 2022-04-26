package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.dto.DestinationDTO;

public class DestinationDTOMapper {

    public static Destination destinationDTOtoDestination(DestinationDTO destinationDTO) {
        Destination destination = new Destination();
        destination.setName(destinationDTO.getName());
        destination.setDescription(destinationDTO.getDescription());
        destination.setActive(destinationDTO.isActive());
        return destination;
    }

    public static Address destinationDTOtoAddress(DestinationDTO destinationDTO) {
        Address address = new Address();
        address.setCity(destinationDTO.getCity());
        address.setPostCode(destinationDTO.getPostCode());
        address.setStreet(destinationDTO.getStreet());
        return address;
    }



}
