package com.sanitas.domain.strategy.impl;


import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SubtractionImplUnitTest {

    @InjectMocks
    private SubtractionImpl subtraction;

    @Test
    public void testExecuteOperationWithEmptyList() {
        final Double expected = 2.0;

        final String operation = "3-1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        final Double result = subtraction.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationWithPriorityList() {
        final Double expected = 2.0;

        final String operation = "3-1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        priorityList.add(EnumArithmeticOperator.ADDITION);

        final Double result = subtraction.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationFirstValueNegative() {
        final Double expected = -4.0;

        final String operation = "-3-1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        priorityList.add(EnumArithmeticOperator.ADDITION);

        final Double result = subtraction.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationOneElement() {
        final Double expected = 3.0;

        final String operation = "3";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        priorityList.add(EnumArithmeticOperator.ADDITION);

        final Double result = subtraction.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }
}
