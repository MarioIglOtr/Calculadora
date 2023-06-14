package unittest.operation;

import com.sanitas.domain.facade.OperationFacade;
import com.sanitas.domain.strategy.Operation;
import com.sanitas.domain.strategy.impl.SumImpl;
import com.sanitas.domain.utils.EnumArithmeticOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SumImplUnitTest {

    @InjectMocks
    private SumImpl sum;

    @Mock
    private OperationFacade operationFacade;

    @Test
    public void testExecuteOperationWithEmptyList(){
        final Double expected = 4.0;

        final String operation = "3+1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        final Double result = sum.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationWithPriorityList() {
        final Double expected = 4.0;

        final String operation = "3+1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        priorityList.add(EnumArithmeticOperator.SUBTRACTION);

        final Operation op = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.SUBTRACTION)).thenReturn(op);

        final List<EnumArithmeticOperator> enumArithmeticOperators = new ArrayList<>();
        when(op.executeOperation(enumArithmeticOperators, "3")).thenReturn(3.0);
        when(op.executeOperation(enumArithmeticOperators, "1")).thenReturn(1.0);

        final Double result = sum.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationFirstValueNegative() {
        final Double expected = -2.0;

        final String operation = "-3+1";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();
        priorityList.add(EnumArithmeticOperator.SUBTRACTION);

        final Operation op = Mockito.mock(Operation.class);
        when(operationFacade.getOperation(EnumArithmeticOperator.SUBTRACTION)).thenReturn(op);

        final List<EnumArithmeticOperator> enumArithmeticOperators = new ArrayList<>();
        when(op.executeOperation(enumArithmeticOperators, "-3")).thenReturn(-3.0);
        when(op.executeOperation(enumArithmeticOperators, "1")).thenReturn(1.0);

        final Double result = sum.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }

    @Test
    public void testExecuteOperationOneElement() {
        final Double expected = 3.0;

        final String operation = "3";

        final List<EnumArithmeticOperator> priorityList = new ArrayList<>();

        final Double result = sum.executeOperation(priorityList, operation);

        assertEquals(expected, result);
    }
}
