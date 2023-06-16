package com.sanitas.domain.strategy;

import com.sanitas.domain.utils.EnumArithmeticOperator;
import com.sanitas.domain.utils.Logger;
import io.corp.calculator.TracerAPI;

import java.util.List;

public interface Operation {

    TracerAPI log = new Logger();

    double executeOperation(List<EnumArithmeticOperator> priorityList, String operation);
}
