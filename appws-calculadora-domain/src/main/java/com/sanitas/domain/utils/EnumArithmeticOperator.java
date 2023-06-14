package com.sanitas.domain.utils;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum EnumArithmeticOperator {

    ADDITION('+', 0),
    SUBTRACTION('-', 1);

    @Getter
    private final Character symbol;
    @Getter
    private final int priority;

    EnumArithmeticOperator(Character symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static List<EnumArithmeticOperator> getOperatorsInPriorityOrder() {
        return Arrays.stream(EnumArithmeticOperator.values())
                .sorted(Comparator.comparingInt(EnumArithmeticOperator::getPriority))
                .collect(Collectors.toList());
    }
}
