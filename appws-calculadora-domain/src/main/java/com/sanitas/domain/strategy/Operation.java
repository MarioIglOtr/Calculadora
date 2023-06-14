package com.sanitas.domain.strategy;

import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Operation {
    double executeOperation(List<EnumArithmeticOperator> priorityList, String operation);
}
