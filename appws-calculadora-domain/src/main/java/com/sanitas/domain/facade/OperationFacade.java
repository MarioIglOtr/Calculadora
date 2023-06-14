package com.sanitas.domain.facade;

import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.stereotype.Service;

@Service
public interface OperationFacade {
    Operation getOperation(EnumArithmeticOperator enumArithmeticOperator);
}
