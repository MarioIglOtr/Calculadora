package integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {com.sanitas.CalculadoraApplication.class})
public class CalculatorControllerTest {

    final String PATH = "/calculator";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCalculateSum() {
        final Double expected = 3.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final String operator = "+";

        final ResponseEntity<Double> responseEntity = restTemplate.getForEntity(
                PATH + "/num1/{num1}/num2/{num2}/operator/{operator}",
                Double.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void testCalculateSub() {
        final Double expected = 3.0;

        final Double num1 = 1.0;
        final Double num2 = 2.0;
        final String operator = "+";

        final ResponseEntity<Double> responseEntity = restTemplate.getForEntity(
                PATH + "/num1/{num1}/num2/{num2}/operator/{operator}",
                Double.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void testCalculate() {
        final Double expected = -3.0;

        final Double num1 = -1.0;
        final Double num2 = -2.0;
        final String operator = "+";

        final ResponseEntity<Double> responseEntity = restTemplate.getForEntity(
                PATH + "/num1/{num1}/num2/{num2}/operator/{operator}",
                Double.class,
                num1, num2, operator);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expected, responseEntity.getBody());
    }

}
