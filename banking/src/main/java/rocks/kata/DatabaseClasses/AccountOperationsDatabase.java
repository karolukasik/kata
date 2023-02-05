package rocks.kata.DatabaseClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rocks.kata.AccountOperation;

public class AccountOperationsDatabase {
    private Map<Long, List<AccountOperation>> operationsDatabase;
    private AccountOperationDatabaseFormatter formatter;

    public AccountOperationsDatabase(AccountOperationDatabaseFormatter formatter) {
        this.operationsDatabase = new HashMap<>();
        this.formatter = formatter;
    }

    public void addOperationToDatabase(long accountID, AccountOperation operation) {
        operationsDatabase.putIfAbsent(accountID, new ArrayList<>());
        operationsDatabase.get(accountID).add(operation);
    }

    @Override
    public String toString() {
        return "Cannot print whole database";
    }

    public String toString(long accountID) {
        List<AccountOperation> listOfOperationsForAccount = operationsDatabase.get(accountID);
        return formatter.createFormattedStringForAccountOperations(listOfOperationsForAccount);
    }

}
