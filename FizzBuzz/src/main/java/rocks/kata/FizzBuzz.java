package rocks.kata;

import java.util.ArrayList;

public class FizzBuzz {
    static FizzBuzz fizz = new FizzBuzz();

    public static void main(String[] args) {
        fizz.printLines(100);
    }

    public String returnFizzBuzzOrNumber(int number) {
        StringBuilder toReturn = new StringBuilder();
        if (number % 3 == 0) {
            toReturn.append("Fizz");
        }
        if (number % 5 == 0) {
            toReturn.append("Buzz");
        }
        if (toReturn.length() == 0) {
            toReturn.append(number);
        }
        return toReturn.toString();
    }

    public void printLines(int numberOfLines) {
        ArrayList<String> lines = createArrayListWithLines(numberOfLines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public ArrayList<String> createArrayListWithLines(int numberOfLines) {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 1; i <= numberOfLines; i++) {
            lines.add(fizz.returnFizzBuzzOrNumber(i));
        }
        return lines;
    }

}
