package com.sanitas.domain.service.Impl;


import com.sanitas.domain.exception.OperatorException;
import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.service.CalculatorService;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Double calculate(@NonNull final Double num1, @NonNull final Double num2, @NonNull Character operator) {

        if (!esOperadorValido(operator)) {
            throw new OperatorException("Invalid operator: " + operator);
        }
        final String operation = transformarOperacion(num1, num2, operator);

        final List<EnumArithmeticOperator> enumArithmeticOperatorsOrderList = EnumArithmeticOperator.getOperatorsInPriorityOrder();

        final Operation firstOperation = OperationFacade.getOperation(enumArithmeticOperatorsOrderList.get(0));
        enumArithmeticOperatorsOrderList.remove(0);

        return firstOperation.executeOperation(enumArithmeticOperatorsOrderList, operation);
    }

    private String transformarOperacion(final Double num1, Double num2, Character operator) {
        boolean cambiarOperador = false;
        if (num2 < 0.0) {
            cambiarOperador = true;
            num2 = Math.abs(num2);
        }

        if (cambiarOperador) {
            final Character additionScaped = EnumArithmeticOperator.ADDITION.getSymbol();

            if (operator.equals(additionScaped)) {
                operator = EnumArithmeticOperator.SUBTRACTION.getSymbol();
            } else {
                operator = EnumArithmeticOperator.ADDITION.getSymbol();
            }
        }

        return num1.toString() + operator.toString() + num2;
    }

    private boolean esOperadorValido(final Character operator) {

        return Stream.of(EnumArithmeticOperator.values())
                .anyMatch(op -> op.getSymbol() == operator);
    }
}
