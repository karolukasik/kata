package rocks.kata;

import rocks.kata.DatabaseClasses.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        var formatter = new AccountOperationDatabaseFormatter();
        var database = new AccountOperationsDatabase(formatter);

        var accountOne = new Account(database);
        var accountTwo = new Account(database);

        accountOne.deposit(100);
        accountOne.deposit(150);
        accountOne.withdraw(30);

        accountTwo.deposit(150);
        accountTwo.withdraw(10);
        accountTwo.deposit(110);
        accountTwo.withdraw(15);

        System.out.println(accountOne.printStatement());
        System.out.println("---");
        System.out.println(accountTwo.printStatement());

    }
}
