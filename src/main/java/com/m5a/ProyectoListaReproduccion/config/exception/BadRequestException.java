package com.m5a.ProyectoListaReproduccion.config.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

  
   
}
