package com.sanitas.api.impl;

import com.sanitas.api.CalculatorController;
import com.sanitas.domain.service.Impl.CalculatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
@Tag(name = "Calculator", description = "Implements arithmetics operations")
public class CalculatorControllerImpl implements CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Override
    public ResponseEntity<Double> calculate(
            @PathVariable final double num1,
            @PathVariable final double num2,
            @PathVariable final char operator) {
        final double result = calculatorService.calculate(num1, num2, operator);

        return ResponseEntity.ok(result);
    }
}


