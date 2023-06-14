package com.sanitas.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public interface CalculatorController {

    @GetMapping("/num1/{num1}/num2/{num2}/operator/{operator}")
    ResponseEntity<Double> calculate(
            @PathVariable Double num1,
            @PathVariable Double num2,
            @PathVariable Character operator);
}
