package com.sanitas.domain.exception;

import lombok.Getter;

public class OperatorException extends RuntimeException {

    @Getter
    private final String errorMenssage;

    public OperatorException(final String errorMenssage) {
        this.errorMenssage = errorMenssage;
    }

    public OperatorException(final Exception exception, final String errorMenssage) {
        super(exception.getMessage());
        this.errorMenssage = errorMenssage;
    }
}
