package com.sanitas.api.impl;

import com.sanitas.api.CalculatorController;

import com.sanitas.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
public class CalculatorControllerImpl implements CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Override
    @GetMapping("/numero/{num1}/numero2/{num2}/operador/{operator}")
    public ResponseEntity<Double> calculate(
            @PathVariable final Double num1,
            @PathVariable final Double num2,
            @PathVariable final String operator) {
        final Double result = calculatorService.calculate(num1, num2, operator);

        return ResponseEntity.ok(result);
    }
}
