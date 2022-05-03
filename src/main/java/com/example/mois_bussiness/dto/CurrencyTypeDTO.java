package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CurrencyTypeDTO {

    Long id;

    String name;

    boolean active;
}
