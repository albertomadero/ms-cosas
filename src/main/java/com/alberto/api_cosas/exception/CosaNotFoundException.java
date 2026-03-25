package com.alberto.api_cosas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CosaNotFoundException extends RuntimeException{
    public CosaNotFoundException(Long id) { super("No se encontro el id: " + id);}
}
