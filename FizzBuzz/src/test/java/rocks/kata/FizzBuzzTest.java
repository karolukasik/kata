package rocks.kata;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FizzBuzzTest {

    private FizzBuzz fizzPattern = new FizzBuzzPattern();
    private FizzBuzz fizzStringBuilder = new FizzBuzzStringBuilder();
    private FizzBuzz fizzLiterals = new FizzBuzzLiterals();
    private FizzBuzz fizzDivisibilityCheck = new FizzBuzzDivisibilityRules();

    @ParameterizedTest
    @ValueSource(ints = { 3, 12, 3 * 100003 })
    void shouldReturnFizzForNumbersDivisibleByThree(int number) {
        assertTrue(fizzPattern.returnFizzBuzzOrNumber(number).equals("Fizz"));
        assertTrue(fizzStringBuilder.returnFizzBuzzOrNumber(number).equals("Fizz"));
        assertTrue(fizzLiterals.returnFizzBuzzOrNumber(number).equals("Fizz"));
        assertTrue(fizzDivisibilityCheck.returnFizzBuzzOrNumber(number).equals("Fizz"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 5, 25, 5 * 100003 })
    void shouldReturnBuzzWhenDivisibleByFive(int number) {
        assertTrue(fizzPattern.returnFizzBuzzOrNumber(number).equals("Buzz"));
        assertTrue(fizzStringBuilder.returnFizzBuzzOrNumber(number).equals("Buzz"));
        assertTrue(fizzLiterals.returnFizzBuzzOrNumber(number).equals("Buzz"));
        assertTrue(fizzDivisibilityCheck.returnFizzBuzzOrNumber(number).equals("Buzz"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 15, 15 * 15, 15 * 100003 })
    void shouldReturnFizzBuzzWhenDivisibleByFifteen(int number) {
        assertTrue(fizzPattern.returnFizzBuzzOrNumber(number).equals("FizzBuzz"));
        assertTrue(fizzStringBuilder.returnFizzBuzzOrNumber(number).equals("FizzBuzz"));
        assertTrue(fizzLiterals.returnFizzBuzzOrNumber(number).equals("FizzBuzz"));
        assertTrue(fizzDivisibilityCheck.returnFizzBuzzOrNumber(number).equals("FizzBuzz"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 19, 98 * 100003 })
    void shouldReturnNumberIfNotDivisibleByThreeOrFive(int number) {
        assertTrue(fizzPattern.returnFizzBuzzOrNumber(number).equals(Integer.toString(number)));
        assertTrue(fizzStringBuilder.returnFizzBuzzOrNumber(number).equals(Integer.toString(number)));
        assertTrue(fizzLiterals.returnFizzBuzzOrNumber(number).equals(Integer.toString(number)));
    }

}
