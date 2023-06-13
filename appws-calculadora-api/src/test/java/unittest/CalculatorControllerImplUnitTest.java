package unittest;

import com.sanitas.api.impl.CalculatorControllerImpl;
import com.sanitas.model.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerImplUnitTest {

    final String PATH = "/calculator";

    @InjectMocks
    private CalculatorControllerImpl calculatorController;

    @Mock
    private CalculatorService calculatorService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void testFindSimilarProductsByProductId() throws Exception {

        final Integer num1 = 1;
        final Integer num2 = 2;
        final String operator = "+";
        final Integer resultOperation = 3;

        when(calculatorService.calculate(num1, num2, operator)).thenReturn(resultOperation);

        mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/numero/{num1}/numero2/{num2}/operador/{operator}", num1, num2, operator))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(calculatorService).calculate(num1, num2, operator);
    }
}
