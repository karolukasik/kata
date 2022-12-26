package rocks.kata;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizz = new FizzBuzz();
        String[] linesToPrint = new String[100];
        IntStream.range(1, linesToPrint.length + 1).forEach(i -> linesToPrint[i - 1] = fizz.returnFizzBuzzOrNumber(i));
        fizz.printLines(linesToPrint);
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

    public void printLines(String[] array) {
        for (String line : array) {
            System.out.println(line);
        }
    }

}
