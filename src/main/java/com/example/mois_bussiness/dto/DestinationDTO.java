package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DestinationDTO {

    Long id;

    @NotBlank(message = "Zadejte název destinace")
    String name;

    boolean active;

    @NotBlank(message = "Zadejte popisek")
    String description;

    AddressDTO address;

    @NotBlank(message = "Zvolte zemi")
    CountryDTO country;

    @NotBlank(message = "Zvolte typ destinace")
    DestinationTypeDTO destinationType;

}
