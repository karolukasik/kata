package rocks.kata;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        var database = new AccountOperationsDatabase();

        var accountOne = new Account(database);
        var accountTwo = new Account(database);

        accountOne.deposit(100);
        accountOne.deposit(150);
        accountTwo.deposit(150);
        accountOne.withdraw(30);
        accountTwo.withdraw(15);
        accountTwo.deposit(110);

        System.out.println(accountOne.printStatement());
        System.out.println(accountTwo.printStatement());

    }
}
