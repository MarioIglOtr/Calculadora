package com.sanitas.domain.service.impl;

import com.sanitas.api.CalculatorController;
import com.sanitas.domain.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorControllerImpl implements CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Override
    public ResponseEntity<Double> calculate(
            @PathVariable final Double num1,
            @PathVariable final Double num2,
            @PathVariable final Character operator) {
        final Double result = calculatorService.calculate(num1, num2, operator);

        return ResponseEntity.ok(result);
    }
}