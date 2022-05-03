package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class OfferDTO {

    Long id;

    @NotBlank(message = "Datum nesmí být prázdné")
    LocalDateTime dateAction;

    @NotBlank(message = "Datum nesmí být prázdné")
    LocalDateTime dateExpiration;

    @NotBlank(message = "Maximální kapacita je povinná")
    int capacity;

    @NotBlank(message = "Popis nesmí být prázdný")
    String description;

    @NotBlank(message = "Datum nesmí být prázdné")
    LocalDateTime dayStart;

    @NotBlank(message = "Datum nesmí být prázdné")
    LocalDateTime dayEnd;

    @NotBlank(message = "Vyplňte cenu")
    double price;

    boolean active;

    @NotBlank(message = "Zvolte destinaci")
    DestinationDTO destination;

    @NotBlank(message = "Zvolte typ jídla")
    FoodTypeDTO foodType;

    @NotBlank(message = "Zvolte typ měny")
    CurrencyTypeDTO currencyType;

    @NotBlank(message = "Zvolte typ cesty")
    TransportTypeDTO transportType;
}
