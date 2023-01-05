package rocks.kata;

import java.util.ArrayList;
import java.util.HashMap;

public class FizzBuzzPattern {
    static FizzBuzzPattern fizz = new FizzBuzzPattern();
    HashMap<String, String> pattern;

    public FizzBuzzPattern() {
        this.pattern = new HashMap<>(3);
        this.pattern.put("0_", "Fizz");
        this.pattern.put("_0", "Buzz");
        this.pattern.put("00", "FizzBuzz");
    }

    protected String returnFizzBuzzOrNumber(int number) {
        String pattern = createPatternFromNumber(number);
        switch (pattern) {
            case "0_":
                return "Fizz";
            case "_0":
                return "Buzz";
            case "00":
                return "FizzBuzz";
            default:
                return Integer.toString(number);
        }

    }

    public void printLines(int numberOfLines) {
        ArrayList<String> lines = createArrayListWithLines(numberOfLines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private ArrayList<String> createArrayListWithLines(int numberOfLines) {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 1; i <= numberOfLines; i++) {
            lines.add(fizz.returnFizzBuzzOrNumber(i));
        }
        return lines;
    }

    private String createPatternFromNumber(int number) {
        StringBuilder pattern = new StringBuilder(2);
        pattern.append(checkDivisibility(number, 3));
        pattern.append(checkDivisibility(number, 5));
        return pattern.toString();
    }

    private String checkDivisibility(int numberToDivide, int divider) {
        if (numberToDivide % divider == 0) {
            return "0";
        } else {
            return "_";
        }
    }

}
