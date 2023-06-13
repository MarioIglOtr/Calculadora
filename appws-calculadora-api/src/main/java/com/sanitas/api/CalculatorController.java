package com.sanitas.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorController {

    @GetMapping("numero/{num1}/numero2/{num2}/operador/{operator}")
    ResponseEntity<Integer> calculate(
            @PathVariable Integer num1,
            @PathVariable Integer num2,
            @PathVariable String operator);
}
