package rocks.kata;

public class FizzBuzzLiterals implements FizzBuzz {

    @Override
    public String returnFizzBuzzOrNumber(int number) {

        if (isNumberDivisible(number, 15)) {
            return "FizzBuzz";
        }
        if (isNumberDivisible(number, 3)) {
            return "Fizz";
        }
        ;
        if (isNumberDivisible(number, 5)) {
            return "Buzz";
        }
        return Integer.toString(number);

    }

    private boolean isNumberDivisible(int number, int divisor) {
        return number % divisor == 0;
    }

}
