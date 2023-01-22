package rocks.kata;

import static rocks.kata.OperationType.*;

import rocks.kata.DatabaseClasses.AccountOperationsDatabase;

public class Account {

    private static long numberOfAccounts;

    private int balance;
    private long uniqueAccountID;
    private AccountOperationsDatabase operationsDatabase;

    public Account(AccountOperationsDatabase operationsDatabase) {
        Account.numberOfAccounts++;
        this.uniqueAccountID = Account.numberOfAccounts;
        this.balance = 0;
        this.operationsDatabase = operationsDatabase;
        operationsDatabase.addOperationToDatabase(uniqueAccountID, new AccountOperation(OPENING, 0, this.balance));

    }

    public void withdraw(int amount) throws NotEnoughBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        if (balance - amount < 0) {
            throw new NotEnoughBalanceException("Insufficient funds on the account");
        }
        balance -= amount;
        createAccountOperationAndAddToDatabase(WITHDRAWAL, amount);
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        balance += amount;
        createAccountOperationAndAddToDatabase(DEPOSIT, amount);
    }

    public String printStatement() {
        return operationsDatabase.toString(uniqueAccountID);
    }

    private void createAccountOperationAndAddToDatabase(OperationType typeOfOperation, int amount) {
        operationsDatabase.addOperationToDatabase(uniqueAccountID,
                new AccountOperation(typeOfOperation, amount, balance));
    }

}
