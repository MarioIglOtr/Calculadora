package com.sanitas.domain.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;

public interface CalculatorService {
    Double calculate(@NonNull Double num1, @NonNull Double num2, @NonNull Character operator);
}
