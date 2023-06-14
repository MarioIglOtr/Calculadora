package com.sanitas.domain.facade;

import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.strategy.impl.SubtractionImpl;
import com.sanitas.domain.strategy.impl.SumImpl;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.stereotype.Service;

@Service
public class OperationFacade {

    public static Operation getOperation(final EnumArithmeticOperator enumArithmeticOperator) {
        return switch (EnumArithmeticOperator.valueOf(enumArithmeticOperator.name())) {
            case ADDITION -> new SumImpl();
            case SUBTRACTION -> new SubtractionImpl();
        };
    }
}
