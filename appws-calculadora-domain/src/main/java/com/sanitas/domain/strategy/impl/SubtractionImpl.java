package com.sanitas.domain.strategy.impl;

import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubtractionImpl implements Operation {

    /**
     * Ejecuta una operación aritmética utilizando la lista de operadores en orden de prioridad y la cadena de la operación especificada.
     * Implementación de la operación de resta.
     *
     * @param priorityList La lista de operadores aritméticos en orden de prioridad.
     * @param operation    La cadena que representa la operación aritmética.
     * @return El resultado de la operación aritmética.
     */
    @Override
    public double executeOperation(final List<EnumArithmeticOperator> priorityList, String operation) {

        Operation nxOperation = null;
        if (!CollectionUtils.isEmpty(priorityList)) {
            nxOperation = OperationFacade.getOperation(priorityList.get(0));
            priorityList.remove(0);
        }

        if (operation.charAt(0) == EnumArithmeticOperator.SUBTRACTION.getSymbol()) {
            operation = "0" + operation;
        }
        final List<String> restas = new ArrayList<>();
        Collections.addAll(restas, operation.split(EnumArithmeticOperator.SUBTRACTION.getSymbol().toString()));

        double result = Double.parseDouble(restas.get(0));
        if (restas.size() != 1) {

            for (int i = 1; i < restas.size(); i++) {
                if (nxOperation == null) {
                    result -= Double.parseDouble(restas.get(i));
                } else {
                    result -= nxOperation.executeOperation(priorityList, restas.get(i));
                }
                log.trace(result);
            }
        }

        return result;

    }
}
