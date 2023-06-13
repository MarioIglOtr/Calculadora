package com.sanitas.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorController {

    ResponseEntity<Integer> calculate(@PathVariable String operation);
}
