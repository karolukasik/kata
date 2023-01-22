package rocks.kata;

import org.junit.jupiter.api.Test;

import rocks.kata.DatabaseClasses.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

class AppTest {

    AccountOperationsDatabase database;
    CurrentDateProvider dateProvider = new CurrentDateProvider();
    AccountOperationDatabaseFormatter formatter = new AccountOperationDatabaseFormatter();

    @BeforeEach
    void createAccountDatabase() {
        database = new AccountOperationsDatabase(formatter);
    }

    @Test
    void newlyCreatedAccountShouldResultInCorrectDatabasePrintedStatement() {
        var account = new Account(database);
        String currentDate = dateProvider.getCurrentDate();

        String statement = account.printStatement();

        assertEquals("Date\t\tAmount\tBalance\n" + currentDate + "\t0\t0", statement);
    }

    @Test
    void accountAfterDepositOperationShouldResultInCorrectDatabasePrintedStatement() {
        var account = new Account(database);
        account.deposit(100);
        String currentDate = dateProvider.getCurrentDate();

        String statement = account.printStatement();

        assertEquals("Date\t\tAmount\tBalance\n" + currentDate + "\t0\t0\n" + currentDate + "\t+100\t100", statement);
    }

    @Test
    void depositOperationShouldReturnExceptionWhenAmountIsNegativeNumber() {
        var account = new Account(database);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-1);
        });

        String expectedMessage = "The transaction value must be positive number";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void depositOperationShouldReturnExceptionWhenAmountIsZero() {
        var account = new Account(database);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });

        String expectedMessage = "The transaction value must be positive number";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void accountAfterDepositAndWithdrawOperationShouldResultInCorrectDatabasePrintedStatement() {
        var account = new Account(database);
        account.deposit(100);
        account.withdraw(80);
        String currentDate = dateProvider.getCurrentDate();

        String statement = account.printStatement();

        assertEquals("Date\t\tAmount\tBalance\n" + currentDate + "\t0\t0\n" + currentDate + "\t+100\t100\n"
                + currentDate + "\t-80\t20", statement);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenAmountIsNegativeNumber() {
        var account = new Account(database);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-5);
        });

        String expectedMessage = "The transaction value must be positive number";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenAmountIsZero() {
        var account = new Account(database);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });

        String expectedMessage = "The transaction value must be positive number";
        String actualValue = exception.getMessage();

        assertEquals(expectedMessage, actualValue);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenBalanceIsLessThanAmount() {
        var account = new Account(database);
        Exception exception = assertThrows(NotEnoughBalanceException.class, () -> {
            account.withdraw(10);
        });

        String expectedMessage = "Insufficient funds on the account";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
