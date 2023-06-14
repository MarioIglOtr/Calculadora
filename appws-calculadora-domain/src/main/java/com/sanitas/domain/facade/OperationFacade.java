package com.sanitas.domain.facade;

import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;

public interface OperationFacade {
    Operation getOperation(EnumArithmeticOperator enumArithmeticOperator);
}
