package com.example.mois_bussiness.dto;

import com.example.mois_bussiness.domain.Destination;
import lombok.Data;

@Data
public class DestinationContactDTO {

     Long id;

     String value;

     ContactDTO contact;

     DestinationDTO destination;
}
