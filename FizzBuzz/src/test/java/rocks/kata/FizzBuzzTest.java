package rocks.kata;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizz = new FizzBuzz();

    @Test
    public void ifDividedByThreeReturnFizz() {
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

}
