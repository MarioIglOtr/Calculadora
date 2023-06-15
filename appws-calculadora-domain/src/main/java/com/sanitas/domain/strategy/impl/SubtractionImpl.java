package com.sanitas.domain.strategy.impl;

import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubtractionImpl implements Operation {

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

        double res = Double.parseDouble(restas.get(0));
        if (restas.size() == 1) {
            return Double.parseDouble(restas.get(0));
        }
        for (int i = 1; i < restas.size(); i++) {
            if (nxOperation == null) {
                res -= Double.parseDouble(restas.get(i));
            } else {
                res -= nxOperation.executeOperation(priorityList, restas.get(i));
            }
        }
        return res;

    }
}
