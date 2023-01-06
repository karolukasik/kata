package rocks.kata;

public class FizzBuzzLauncher {
    public static void main(String[] args) {
        FizzBuzz[] fizzs = { new FizzBuzzLiterals(), new FizzBuzzPattern(), new FizzBuzzStringBuilder() };

        for (FizzBuzz fizz : fizzs) {
            System.out.println(fizz.getClass().getSimpleName());
            printFizzBuzzInLines(fizz, 100);
            System.out.println("---");
        }

    }

    private static void printFizzBuzzInLines(FizzBuzz fizz, int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i++) {
            System.out.println(fizz.returnFizzBuzzOrNumber(i));
        }
    }
}
