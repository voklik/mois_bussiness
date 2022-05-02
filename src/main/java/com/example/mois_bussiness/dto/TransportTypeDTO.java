package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TransportTypeDTO {

    Long id;

    String name;

    boolean active;
}
