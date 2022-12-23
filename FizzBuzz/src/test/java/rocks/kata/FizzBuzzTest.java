package rocks.kata;


import static org.junit.Assert.assertTrue;


import org.junit.Test;


public class FizzBuzzTest {

    private FizzBuzz fizz = new FizzBuzz();

    @Test
    public void ifDividedByThreeReturnFizz() {
        String checkNumber6 = fizz.returnFizzBuzzOrNumber(6);
        String checkNumber9 = fizz.returnFizzBuzzOrNumber(9);

        assertTrue(checkNumber6.equals("Fizz"));
        assertTrue(checkNumber9.equals("Fizz"));

    }
    //if multiple of 5, return Buzz
    //if multiple of 15, return FizzBuzz
    //if not multiple by 3 or 5, return number
    
}
