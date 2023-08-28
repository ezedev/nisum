package com.nisum.demo.infrastructure.config;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String mensaje;

    public ErrorResponse(String mensaje) {
        this.mensaje = mensaje;
    }
}
