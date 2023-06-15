package com.sanitas.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorController {

    @GetMapping("/num1/{num1}/num2/{num2}/operator/{operator}")
    ResponseEntity<Double> calculate(
            @PathVariable double num1,
            @PathVariable double num2,
            @PathVariable char operator);
}
