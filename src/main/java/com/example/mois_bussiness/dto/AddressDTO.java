package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddressDTO {

    Long id;

    @NotBlank(message = "Město je povinné")
    private String city;

    @NotBlank(message = "PSČ je povinné")
    private String postCode;

    @NotBlank(message = "Ulice je povinná")
    private String street;
}
