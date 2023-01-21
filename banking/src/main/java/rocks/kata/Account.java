package rocks.kata;

import static rocks.kata.OperationType.*;

public class Account {

    private static long numberOfAccounts;

    private int balance;
    private long uniqueAccountID;
    private AccountOperationsDatabase operationsDatabase;

    public Account(AccountOperationsDatabase operationsDatabase) {
        Account.numberOfAccounts++;
        this.balance = 0;
        this.operationsDatabase = operationsDatabase;
        this.uniqueAccountID = Account.numberOfAccounts;
        operationsDatabase.addOperationToDatabase(uniqueAccountID, new AccountOperation(OPENING, 0, this.balance));

    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        if (balance - amount < 0) {
            // find or create new exception
            System.out.println("Insufficient funds in the account");
            return;
        }
        balance -= amount;
        operationsDatabase.addOperationToDatabase(uniqueAccountID, new AccountOperation(WITHDRAWAL, amount, balance));
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        balance += amount;
        operationsDatabase.addOperationToDatabase(uniqueAccountID, new AccountOperation(DEPOSIT, amount, balance));
    }

    public String printStatement() {
        return operationsDatabase.toString(uniqueAccountID);
    }

}
