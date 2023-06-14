package com.sanitas.model.service;

import lombok.NonNull;

public interface CalculatorService {
    Double calculate(@NonNull Double num1, @NonNull Double num2, @NonNull String operator);
}
