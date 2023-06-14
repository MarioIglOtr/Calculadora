package com.sanitas.model.exception;

import lombok.Getter;

public class OperatorException extends RuntimeException{

    @Getter
    private String mensaje;

    public OperatorException(final String mensaje) {
        this.mensaje = mensaje;
    }
    public OperatorException(final String error, final String mensaje) {
        super(error);
        this.mensaje = mensaje;
    }
}
