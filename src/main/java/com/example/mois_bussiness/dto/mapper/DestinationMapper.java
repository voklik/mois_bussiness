package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.dto.AddressDTO;
import com.example.mois_bussiness.dto.CountryDTO;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.dto.DestinationTypeDTO;
import org.springframework.stereotype.Component;

@Component
public class DestinationMapper {

    public DestinationDTO destinationToDTO(Destination destination) {
        DestinationDTO destinationDTO = new DestinationDTO();
        destinationDTO.setName(destination.getName());
        destinationDTO.setDescription(destination.getDescription());
        destinationDTO.setActive(destination.isActive());

        AddressDTO address = new AddressDTO();
        address.setId(destination.getAddress().getId());
        address.setPostCode(destination.getAddress().getPostCode());
        address.setCity(destination.getAddress().getCity());
        address.setStreet(destination.getAddress().getStreet());

        destinationDTO.setAddress(address);

        CountryDTO country = new CountryDTO();
        country.setId(destination.getCountry().getId());
        country.setCountry(destination.getCountry().getCountry());

        destinationDTO.setCountry(country);

        DestinationTypeDTO destinationType = new DestinationTypeDTO();
        destinationType.setId(destination.getDestinationType().getId());
        destinationType.setName(destination.getDestinationType().getName());

        destinationDTO.setDestinationType(destinationType);

        return destinationDTO;
    }

}
