package com.example.mois_bussiness.dto;

import com.example.mois_bussiness.domain.Offer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDestinationDTO {

    Long id;

    LocalDateTime dateOrder;

    double price;

    double discount;

    Offer offer;

    Long orderStateId;

    Long currencyTypeId;

    Long userId;
}
