package com.example.mois_bussiness.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class MessageResponse {

    private Date timestamp;
    private String message;
    private int status;

}