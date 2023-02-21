package rocks.kata;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import rocks.kata.AccountOperation.OperationType;
import rocks.kata.DatabaseClasses.AccountOperationsDatabase;

public class Account {

    private static final AtomicLong numberOfAccounts = new AtomicLong();

    private AtomicInteger balance;
    private long uniqueAccountID;
    private AccountOperationsDatabase operationsDatabase;

    public Account(AccountOperationsDatabase operationsDatabase) {
        this.uniqueAccountID = numberOfAccounts.incrementAndGet();
        this.balance = new AtomicInteger(0);
        this.operationsDatabase = operationsDatabase;

    }

    public void withdraw(int amount) throws NotEnoughBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        synchronized (this) {
            if (balance.intValue() - amount < 0) {
                throw new NotEnoughBalanceException("Insufficient funds on the account");
            }
            saveOperationToDatabase(OperationType.WITHDRAWAL, amount);
        }
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The transaction value must be positive number");
        }
        saveOperationToDatabase(OperationType.DEPOSIT, amount);
    }

    public String printStatement() {
        return operationsDatabase.formattedAccountOperations(uniqueAccountID);
    }

    private synchronized void saveOperationToDatabase(OperationType typeOfOperation, int amount) {
        var balanceAfterOperation = calculateBalanceAfterOperation(typeOfOperation, amount);
        var operation = new AccountOperation(typeOfOperation, amount,
                balanceAfterOperation);
        operationsDatabase.addOperationToDatabase(uniqueAccountID, operation);
    }

    private int calculateBalanceAfterOperation(OperationType typeOfOperation, int amount) {
        return switch (typeOfOperation) {
            case WITHDRAWAL -> balance.addAndGet(-amount);
            case DEPOSIT -> balance.addAndGet(amount);
        };
    }

    public long getUniqueAccountID() {
        return uniqueAccountID;
    }

}
