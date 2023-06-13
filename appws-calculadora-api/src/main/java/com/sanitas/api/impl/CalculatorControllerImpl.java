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
    @GetMapping("/{operation}")
    public ResponseEntity<Integer> calculate(@PathVariable final String operation) {
        final Integer result = calculatorService.calculate(operation);

        return ResponseEntity.ok(result);
    }
}
