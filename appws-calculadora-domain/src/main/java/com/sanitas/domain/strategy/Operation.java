package com.sanitas.domain.strategy;

import com.sanitas.domain.utils.EnumArithmeticOperator;

import java.util.List;

public interface Operation {
    double executeOperation(List<EnumArithmeticOperator> priorityList, String operation);
}
