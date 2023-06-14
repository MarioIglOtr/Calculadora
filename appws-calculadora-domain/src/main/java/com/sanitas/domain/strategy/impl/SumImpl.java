package com.sanitas.domain.strategy.impl;

import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.facade.impl.OperationFacadeImpl;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SumImpl implements Operation {

    @Autowired
    private OperationFacade operationFacade = new OperationFacadeImpl();

    @Override
    public double executeOperation(final List<EnumArithmeticOperator> priorityList, final String operation) {

        Operation nxOperation = null;
        if (!CollectionUtils.isEmpty(priorityList)) {
            nxOperation = operationFacade.getOperation(priorityList.get(0));
            priorityList.remove(0);
        }

        final List<String> sumas = new ArrayList<>();

        final String additionScaped = Pattern.quote(String.valueOf(EnumArithmeticOperator.ADDITION.getSymbol()));
        Collections.addAll(sumas, operation.split(additionScaped));
        double result = 0;
        for (final String op : sumas) {
            if (nxOperation == null) {
                result += Double.parseDouble(op);
            } else {
                result += nxOperation.executeOperation(priorityList, op);
            }
        }

        return result;
    }
}
