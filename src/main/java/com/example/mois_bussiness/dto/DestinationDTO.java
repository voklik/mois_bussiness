package com.example.mois_bussiness.dto;

import lombok.Data;

@Data
public class DestinationDTO {

    Long id;

    String name;

    boolean active;

    String description;

    AddressDTO address;

    CountryDTO country;

    DestinationTypeDTO destinationType;

}
