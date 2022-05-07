package com.example.mois_bussiness.handler;

import com.example.mois_bussiness.exception.InternalErrorException;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.payload.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler({ObjectNotExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse handleObjectNotExist(Exception e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageResponse handleInternalError(InternalErrorException e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
