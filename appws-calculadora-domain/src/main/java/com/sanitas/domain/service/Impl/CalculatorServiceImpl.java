package com.sanitas.domain.service.Impl;


import com.sanitas.domain.exception.OperatorException;
import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.service.CalculatorService;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    /**
     * Realiza un cálculo aritmético utilizando los números y el operador especificados.
     *
     * @param num1     El primer número de la operación.
     * @param num2     El segundo número de la operación.
     * @param operator El operador aritmético.
     * @return El resultado del cálculo aritmético.
     * @throws OperatorException Si el operador especificado no es válido.
     */
    @Override
    public double calculate(final double num1, final double num2, char operator) {

//        final TracerImpl tracerAPI = new TracerImpl();

        if (!esOperadorValido(operator)) {
            throw new OperatorException("Invalid operator: " + operator);
        }
        final String operation = transformarOperacion(num1, num2, operator);

        final List<EnumArithmeticOperator> enumArithmeticOperatorsOrderList = EnumArithmeticOperator.getOperatorsInPriorityOrder();

        final Operation firstOperation = OperationFacade.getOperation(enumArithmeticOperatorsOrderList.get(0));
        enumArithmeticOperatorsOrderList.remove(0);

        double resutl = firstOperation.executeOperation(enumArithmeticOperatorsOrderList, operation);
//        tracerAPI.trace(resutl);
        return resutl;
    }


    /**
     * Transforma una operación aritmética en una cadena de texto. Si encuentra un numero negativo en la segunda
     * posición modifica el operador para simplificar el resultado
     *
     * @param num1     El primer número de la operación.
     * @param num2     El segundo número de la operación.
     * @param operator El operador aritmético.
     * @return La representación en texto de la operación aritmética.
     */
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

    /**
     * Verifica si un operador aritmético es válido.
     *
     * @param operator El operador aritmético a verificar.
     * @return true si el operador es válido, false de lo contrario.
     */
    private boolean esOperadorValido(final Character operator) {

        return Stream.of(EnumArithmeticOperator.values())
                .anyMatch(op -> op.getSymbol() == operator);
    }
}
