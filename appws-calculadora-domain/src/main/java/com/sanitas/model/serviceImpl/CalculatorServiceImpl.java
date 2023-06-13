package com.sanitas.model.serviceImpl;


import com.sanitas.model.service.CalculatorService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Integer calculate(@NonNull final Integer num1, @NonNull final Integer num2, @NonNull final String operator) {

        final String operation = num1 + operator + num2;

        return operation(operation);
    }

    private Integer operation(final String operation) {


        return null;
    }


}
