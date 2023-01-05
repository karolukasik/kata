package rocks.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private FizzBuzzPattern fizz = new FizzBuzzPattern();

    @Test
    public void checkPrintingResultForFirstFifteenLines() {
        fizz.printLines(15);
        String expectedResult = "1\r\n2\r\nFizz\r\n4\r\nBuzz\r\nFizz\r\n7\r\n8\r\nFizz\r\nBuzz\r\n11\r\nFizz\r\n13\r\n14\r\nFizzBuzz";
        
        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }

    @Test
    public void ifDivisibleByThreeReturnFizz() {
        String checkNumberSix = fizz.returnFizzBuzzOrNumber(6);
        String checkNumberNine = fizz.returnFizzBuzzOrNumber(9);

        assertTrue(checkNumberSix.equals("Fizz"));
        assertTrue(checkNumberNine.equals("Fizz"));
    }

    @Test
    public void ifDivisibleByFiveReturnBuzz() {
        String checkNumberFive = fizz.returnFizzBuzzOrNumber(5);
        String checkNumberTen = fizz.returnFizzBuzzOrNumber(10);

        assertTrue(checkNumberFive.equals("Buzz"));
        assertTrue(checkNumberTen.equals("Buzz"));
    }

    @Test
    public void ifDivisibleByFifteenReturnFizzBuzz() {
        String checkNumberFifteen = fizz.returnFizzBuzzOrNumber(15);
        String checkNumberFortyFive = fizz.returnFizzBuzzOrNumber(45);

        assertTrue(checkNumberFifteen.equals("FizzBuzz"));
        assertTrue(checkNumberFortyFive.equals("FizzBuzz"));
    }

    @Test
    public void ifNotDivisibleByThreeOrFiveReturnNumber() {
        String checkNumberTwo = fizz.returnFizzBuzzOrNumber(2);
        String checkNumberNineteen = fizz.returnFizzBuzzOrNumber(19);

        assertTrue(checkNumberTwo.equals("2"));
        assertTrue(checkNumberNineteen.equals("19"));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
