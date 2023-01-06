package rocks.kata;


public class FizzBuzzDivisibilityRules implements FizzBuzz {

    @Override
    public String returnFizzBuzzOrNumber(int number) {
        // TODO Auto-generated method stub
        return null;
    }

    private boolean isDivisibleBy3(int number) {
        int sum = calculateSumOfDigits(number);
        return false;
    }

    private int calculateSumOfDigits(int number) {
        return -1;

    }

    private boolean isDivisibleBy5(int number) {
        int lastDigit = number % 10;
        return lastDigit == 0 || lastDigit == 5;
    }

    private boolean isDivisibleBy15(int number) {
        return isDivisibleBy3(number) && isDivisibleBy5(number);
    }

}
