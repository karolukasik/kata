package rocks.kata;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizz = new FizzBuzz();
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizz.returnFizzBuzzOrNumber(i));
        }
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

}
