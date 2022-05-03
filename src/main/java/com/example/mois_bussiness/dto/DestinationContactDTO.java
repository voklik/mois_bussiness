package com.example.mois_bussiness.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DestinationContactDTO {

     Long id;

     @NotBlank(message = "Zadejte mail/číslo")
     String value;

     @NotBlank(message = "Zvolte typ kontaktu")
     ContactDTO contact;

     DestinationDTO destination;
}
