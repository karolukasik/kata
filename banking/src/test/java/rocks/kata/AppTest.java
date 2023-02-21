package rocks.kata;

import org.junit.jupiter.api.Test;

import rocks.kata.DatabaseClasses.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.function.Executable;

class AppTest {

    DateProvider dateProvider = new DateProvider("d.M.yyyy");
    AccountOperationDatabaseFormatter formatter = new AccountOperationDatabaseFormatter();
    AccountOperationsDatabase database = new AccountOperationsDatabase(formatter);

    @Test
    void newlyCreatedAccountShouldResultInCorrectDatabasePrintedStatement() {
        var account = new Account(database);

        String statement = account.printStatement();

        assertEquals("Date\t\tAmount\tBalance", statement);
    }

    @Test
    void accountAfterDepositOperationShouldResultInCorrectDatabasePrintedStatement() {
        var account = new Account(database);
        account.deposit(100);
        String currentDate = dateProvider.getCurrentDate();

        String statement = account.printStatement();

        assertEquals("Date\t\tAmount\tBalance\n" + currentDate + "\t+100\t100", statement);
    }

    @Test
    void depositOperationShouldReturnExceptionWhenAmountIsNegativeNumber() {
        var account = new Account(database);
        String expectedMessage = "The transaction value must be positive number";

        Executable methodToExecute = () -> account.deposit(-1);

        Exception exception = assertThrows(IllegalArgumentException.class, methodToExecute);
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void depositOperationShouldReturnExceptionWhenAmountIsZero() {
        var account = new Account(database);
        String expectedMessage = "The transaction value must be positive number";

        Executable methodToExecute = () -> account.deposit(0);

        Exception exception = assertThrows(IllegalArgumentException.class, methodToExecute);
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

        assertEquals("Date\t\tAmount\tBalance\n" + currentDate + "\t+100\t100\n"
                + currentDate + "\t-80\t20", statement);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenAmountIsNegativeNumber() {
        var account = new Account(database);
        String expectedMessage = "The transaction value must be positive number";

        Executable methodToExecute = () -> account.withdraw(-5);

        Exception exception = assertThrows(IllegalArgumentException.class, methodToExecute);
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenAmountIsZero() {
        var account = new Account(database);
        String expectedMessage = "The transaction value must be positive number";

        Executable methodToExecute = () -> account.withdraw(0);

        Exception exception = assertThrows(IllegalArgumentException.class, methodToExecute);
        String actualValue = exception.getMessage();
        assertEquals(expectedMessage, actualValue);
    }

    @Test
    void withdrawOperationShouldReturnExceptionWhenBalanceIsLessThanAmount() {
        var account = new Account(database);
        String expectedMessage = "Insufficient funds on the account";

        Executable methodToExecute = () -> account.withdraw(10);
        
        Exception exception = assertThrows(NotEnoughBalanceException.class, methodToExecute);
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
        
    }
    


}
