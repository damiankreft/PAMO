package pl.edu.pja.s23447.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

import services.CalculationsService;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void calculates_bmi() {
        // given // arrange
        CalculationsService service = new CalculationsService();
        double weight = 77;
        double height = 1.8;

        // when // act
        double bmi = service.calculateBmi(height, weight);

        // then // assert
        assertEquals(23.76543209876543, bmi, 0.5);
    }
}