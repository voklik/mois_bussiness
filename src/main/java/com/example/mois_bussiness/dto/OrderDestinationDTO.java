package com.example.mois_bussiness.dto;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.domain.OrderState;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDestinationDTO {

    Long id;

    LocalDateTime dateOrder;

    double price;

    OfferDTO offer;

    OrderState orderState;

    CurrencyType currencyType;

    Long userId;
}
