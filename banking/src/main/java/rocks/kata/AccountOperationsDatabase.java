package rocks.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountOperationsDatabase {
    private Map<Long, List<AccountOperation>> operationsDatabase;
    private AccountOperationDatabaseFormatter formatter;

    public AccountOperationsDatabase() {
        this.operationsDatabase = new HashMap<>();
        this.formatter = new AccountOperationDatabaseFormatter(this);
    }

    public void addOperationToDatabase(long accountID, AccountOperation operation) {
        if (!operationsDatabase.keySet().contains(accountID)) {
            operationsDatabase.put(accountID, new ArrayList<>());
        }

        operationsDatabase.get(accountID).add(operation);
    }

    public Map<Long, List<AccountOperation>> getOperationsDatabase() {
        return operationsDatabase;
    }

    @Override
    public String toString() {
        return "Cannot print whole database";
    }

    public String toString(long accountID) {
        return formatter.format(accountID);
    }

}
