package com.sanitas.api.impl;

import com.sanitas.api.CalculatorController;
import com.sanitas.domain.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Calculate result os operation",
            description = "Perform addition and subtraction operations.")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = double.class))})})
    public ResponseEntity<Double> calculate(
            @PathVariable final double num1,
            @PathVariable final double num2,
            @PathVariable final char operator) {
        final double result = calculatorService.calculate(num1, num2, operator);

        return ResponseEntity.ok(result);
    }
}


