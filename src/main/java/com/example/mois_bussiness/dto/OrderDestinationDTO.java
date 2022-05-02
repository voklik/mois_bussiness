package com.example.mois_bussiness.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDestinationDTO {

    Long id;

    LocalDateTime dateOrder;

    double price;

    double discount;

    OfferDTO offer;

    OrderStateDTO orderState;

    CurrencyTypeDTO currencyType;

    Long userId;
}
