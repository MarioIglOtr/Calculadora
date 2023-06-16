package com.sanitas.domain.utils;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

public class Logger implements TracerAPI {

    private final TracerImpl tracer = new TracerImpl();

    @Override
    public <T> void trace(T t) {
        tracer.trace(t);
    }
}
