package rocks.kata;

public class FizzBuzzModulo implements FizzBuzz {

    @Override
    public String getFizzBuzzOrNumber(int number) {
        var toReturn = new StringBuilder();
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
