package com.sanitas.domain.exception;

import lombok.Getter;

public class OperatorException extends RuntimeException{

    @Getter
    private final String mensaje;

    public OperatorException(final String mensaje) {
        this.mensaje = mensaje;
    }
    public OperatorException(final String error, final String mensaje) {
        super(error);
        this.mensaje = mensaje;
    }
}
