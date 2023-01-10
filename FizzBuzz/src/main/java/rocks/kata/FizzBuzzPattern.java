package rocks.kata;

import java.util.HashMap;

public class FizzBuzzPattern implements FizzBuzz {

    HashMap<String, String> pattern;

    public FizzBuzzPattern() {
        this.pattern = new HashMap<>(3);
        this.pattern.put("0_", "Fizz");
        this.pattern.put("_0", "Buzz");
        this.pattern.put("00", "FizzBuzz");
    }

    public String getFizzBuzzOrNumber(int number) {
        var patternForNumber = createPatternFromNumber(number);

        return pattern.getOrDefault(patternForNumber, Integer.toString(number));
    }

    private String createPatternFromNumber(int number) {
        var pattern = new StringBuilder(2);
        pattern.append(checkDivisibility(number, 3));
        pattern.append(checkDivisibility(number, 5));

        return pattern.toString();
    }

    private String checkDivisibility(int numberToDivide, int divider) {
        if (numberToDivide % divider == 0) {
            return "0";
        }
        return "_";
    }

}
