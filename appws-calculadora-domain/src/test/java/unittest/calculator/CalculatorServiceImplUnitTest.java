package unittest.calculator;

import com.sanitas.domain.exception.OperatorException;
import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.service.Impl.CalculatorServiceImpl;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceImplUnitTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Mock
    private OperationFacade operationFacade;

    @Test
    public void testCalcuteBaseCaseSum() {
        final Double expected = 3.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final Character operator = '+';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "1.0+2.0")).thenReturn(expected);

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateDecimals() {
        final Double expected = 3.5;

        final Double num1 = 1.5;
        final Double num2 = 2.0;
        final Character operator = '+';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "1.5+2.0")).thenReturn(expected);

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcuteBaseCaseDif() {
        final Double expected = -1.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final Character operator = '-';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "1.0-2.0")).thenReturn(expected);

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumPositiveNums() {
        final Double expected = 3.0;

        final Double num1 = +1.0;
        final Double num2 = +2.0;
        final Character operator = '+';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "1.0+2.0")).thenReturn(expected);

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumNegativeNums() {
        final Double expected = -3.0;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = '+';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "-1.0-2.0")).thenReturn(expected);

        final Double result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteDifNegativeNums() {
        final Double expected = 1.0;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final Character operator = '-';

        final Operation operation = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.ADDITION)).thenReturn(operation);

        final List<EnumArithmeticOperator> enumArithmeticOperators = List.of(EnumArithmeticOperator.SUBTRACTION);
        when(operation.executeOperation(enumArithmeticOperators, "-1.0+2.0")).thenReturn(expected);

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
