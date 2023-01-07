package rocks.kata;

public class FizzBuzzPrinter {
    public static void main(String[] args) {
        FizzBuzz[] fizzs = { 
            //new FizzBuzzLiterals(), new FizzBuzzPattern(), new FizzBuzzStringBuilder(), 
            new FizzBuzzDivisibilityRules() };

        for (FizzBuzz fizz : fizzs) {
            System.out.println(fizz.getClass().getSimpleName());
            printFizzBuzzInLines(fizz, 15);
            System.out.println("---");
        }

    }

    private static void printFizzBuzzInLines(FizzBuzz fizz, int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i++) {
            System.out.println(fizz.returnFizzBuzzOrNumber(i));
        }
    }
}
