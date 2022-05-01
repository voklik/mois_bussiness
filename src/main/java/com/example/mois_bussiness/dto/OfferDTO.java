package com.example.mois_bussiness.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OfferDTO {

    Long id;

    LocalDateTime dateAction;

    LocalDateTime dateExpiration;

    int capacity;

    String description;

    LocalDateTime dayStart;

    LocalDateTime dayEnd;

    double price;

    boolean active;

    double discount;

    Long destinationId;

    Long foodTypeId;

    Long currencyTypeId;

    Long transportTypeId;
}
