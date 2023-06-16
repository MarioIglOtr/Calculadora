package com.sanitas.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorController {

    @Operation(
            summary = "Calculate result os operation",
            description = "Perform addition(+) and subtraction operations(-).")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = double.class))})})
    @GetMapping("/num1/{num1}/num2/{num2}/operator/{operator}")
    ResponseEntity<Double> calculate(
            @PathVariable double num1,
            @PathVariable double num2,
            @PathVariable char operator);
}
