package integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={com.sanitas.CalculadoraApplication.class})
public class CalculatorControllerTest {

    final String PATH = "/calculator";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCalculateSum() {
        final Integer expected = 3;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final String operator = "+";

        final ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                PATH + "/numero/{num1}/numero2/{num2}/operador/{operator}",
                Integer.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void testCalculateSub() {
        final Integer expected = 3;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final String operator = "+";

        final ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                PATH + "/numero/{num1}/numero2/{num2}/operador/{operator}",
                Integer.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void testCalculate() {
        final Integer expected = -3;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final String operator = "+";

        final ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                PATH + "/numero/{num1}/numero2/{num2}/operador/{operator}",
                Integer.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

}
