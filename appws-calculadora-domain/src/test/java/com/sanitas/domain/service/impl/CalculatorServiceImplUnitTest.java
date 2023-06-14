package com.sanitas.domain.service.impl;

import com.sanitas.domain.exception.OperatorException;
import com.sanitas.domain.service.Impl.CalculatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceImplUnitTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Test
    public void testCalcuteBaseCaseSum() {
        final Double expected = 3.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final Character operator = '+';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateDecimals() {
        final Double expected = 3.5;

        final Double num1 = 1.5;
        final Double num2 = 2.0;
        final Character operator = '+';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcuteBaseCaseDif() {
        final Double expected = -1.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final Character operator = '-';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumPositiveNums() {
        final Double expected = 3.0;

        final Double num1 = +1.0;
        final Double num2 = +2.0;
        final Character operator = '+';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumNegativeNums() {
        final Double expected = -3.0;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = '+';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteDifNegativeNums() {
        final Double expected = 1.0;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = '-';

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test(expected = OperatorException.class)
    public void testCalcualteNonValidOperator() {

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = '*';

        calculatorService.calculate(num1, num2, operator);

    }

    @Test(expected = OperatorException.class)
    public void testCalcualteNonEmptyOpertor() {

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = ' ';

        calculatorService.calculate(num1, num2, operator);

    }

}
