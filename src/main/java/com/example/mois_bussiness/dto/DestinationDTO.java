package com.example.mois_bussiness.dto;

import com.example.mois_bussiness.domain.Country;
import com.example.mois_bussiness.domain.DestinationType;
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
    Country country;

    @NotBlank(message = "Zvolte typ destinace")
    DestinationType destinationType;

}
