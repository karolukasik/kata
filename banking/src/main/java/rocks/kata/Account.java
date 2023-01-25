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
        saveOperationToDatabase(OPENING, 0);

    }

    public void withdraw(int amount) throws NotEnoughBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        if (balance - amount < 0) {
            throw new NotEnoughBalanceException("Insufficient funds on the account");
        }
        saveOperationToDatabase(WITHDRAWAL, amount);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        saveOperationToDatabase(DEPOSIT, amount);
    }

    public String printStatement() {
        return operationsDatabase.toString(uniqueAccountID);
    }

    private void saveOperationToDatabase(OperationType typeOfOperation, int amount) {
        balance = calculateBalanceAfterOperation(typeOfOperation, amount);
        operationsDatabase.addOperationToDatabase(uniqueAccountID,
                new AccountOperation(typeOfOperation, amount, balance));
    }

    private int calculateBalanceAfterOperation(OperationType typeOfOperation, int amount) {
        switch (typeOfOperation) {
            case WITHDRAWAL:
                return balance - amount;
            case DEPOSIT:
                return balance + amount;
            case OPENING:
                return balance;
            //Czy jest mozliwosc żeby Java sprawdzała że są tylko 3 enumy zdefiniowane, wiec nie ma potrzeby defaulta?
            default:
                 return -1;
        }
    }

}
