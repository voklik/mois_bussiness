package com.example.mois_bussiness.dto;

import lombok.Data;

@Data
public class DestinationDTO {

    Long id;

    String name;

    boolean active;

    String description;

    Long countryId;

    Long destinationTypeId;
}
