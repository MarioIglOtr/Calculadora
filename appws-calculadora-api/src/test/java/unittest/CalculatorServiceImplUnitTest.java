package unittest;

import com.sanitas.exception.OperatorException;
import com.sanitas.model.serviceImpl.CalculatorServiceImpl;
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
        final Integer expected = 3;

        final Integer num1 = 1;
        final Integer num2 = 2;
        final String operator = "+";

        final Integer result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcuteBaseCaseDif() {
        final Integer expected = 3;

        final Integer num1 = 1;
        final Integer num2 = 2;
        final String operator = "-";

        final Integer result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumPositiveNums() {
        final Integer expected = 3;

        final Integer num1 = +1;
        final Integer num2 = +2;
        final String operator = "+";

        final Integer result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteSumNegativeNums() {
        final Integer expected = -3;

        final Integer num1 = -1;
        final Integer num2 = -2;
        final String operator = "+";

        final Integer result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcualteDifNegativeNums() {
        final Integer expected = 1;

        final Integer num1 = -1;
        final Integer num2 = -2;
        final String operator = "-";

        final Integer result = calculatorService.calculate(num1, num2, operator);

        assertEquals(expected, result);
    }

    @Test(expected = OperatorException.class)
    public void testCalcualteNonValidOperator() {

        final Integer num1 = -1;
        final Integer num2 = -2;
        final String operator = "*";

        calculatorService.calculate(num1, num2, operator);

    }

    @Test(expected = OperatorException.class)
    public void testCalcualteNonEmptyOpertor() {

        final Integer num1 = -1;
        final Integer num2 = -2;
        final String operator = "*";

        calculatorService.calculate(num1, num2, operator);

    }

}
