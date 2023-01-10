package rocks.kata;

import java.util.Map;
import static rocks.kata.DivisibilityStatus.*;

public class FizzBuzzDivisibilityRules implements FizzBuzz {

    private Map<DivisibilityStatus, String> fizzBuzzTranslation = Map.of(
            DIVISIBLE_BY_3, "Fizz",
            DIVISIBLE_BY_5, "Buzz",
            DIVISIBLE_BY_15, "FizzBuzz");

    @Override
    public String getFizzBuzzOrNumber(int number) {
        var checkDivisibilityStatus = checkDivisibility(number);

        return fizzBuzzTranslation.getOrDefault(checkDivisibilityStatus, Integer.toString(number));
    }

    private DivisibilityStatus checkDivisibility(int number) {
        if (isDivisibleBy15(number)) {
            return DIVISIBLE_BY_15;
        }
        if (isDivisibleBy3(number)) {
            return DIVISIBLE_BY_3;
        }
        if (isDivisibleBy5(number)) {
            return DIVISIBLE_BY_5;
        }
        return NO_MATCHING_DIVISIBILITY;

    }

    private boolean isDivisibleBy3(int number) {
        // calculate the sum of digits in the given number until it becomes a single
        // digit
        int helper = number;
        do {
            helper = calculateSumOfDigits(helper);
        } while (helper >= 10);

        int sumOfDigits = helper;
        if (sumOfDigits == 3 || sumOfDigits == 6 || sumOfDigits == 9) {
            return true;
        }
        return false;
    }

    private int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    private boolean isDivisibleBy5(int number) {
        int lastDigit = number % 10;
        return lastDigit == 0 || lastDigit == 5;
    }

    private boolean isDivisibleBy15(int number) {
        return isDivisibleBy3(number) && isDivisibleBy5(number);
    }

}
