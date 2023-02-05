package rocks.kata;

import static rocks.kata.OperationType.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

import rocks.kata.DatabaseClasses.AccountOperationsDatabase;

public class Account {

    private static final LongAdder numberOfAccounts = new LongAdder();

    private AtomicInteger balance;
    private long uniqueAccountID;
    private AccountOperationsDatabase operationsDatabase;

    public Account(AccountOperationsDatabase operationsDatabase) {
        numberOfAccounts.increment();
        this.uniqueAccountID = numberOfAccounts.sum();
        this.balance = new AtomicInteger(0);
        this.operationsDatabase = operationsDatabase;
        saveOperationToDatabase(OPENING, 0);

    }

    public void withdraw(int amount) throws NotEnoughBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        if (balance.intValue() - amount < 0) {
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
        balance.getAndSet(calculateBalanceAfterOperation(typeOfOperation, amount));
        operationsDatabase.addOperationToDatabase(uniqueAccountID,
                new AccountOperation(typeOfOperation, amount, balance.get()));
    }

    private int calculateBalanceAfterOperation(OperationType typeOfOperation, int amount) {
        return switch (typeOfOperation) {
            case WITHDRAWAL -> balance.addAndGet(-amount);
            case DEPOSIT -> balance.addAndGet(amount);
            case OPENING -> 0;
        };
    }

}
