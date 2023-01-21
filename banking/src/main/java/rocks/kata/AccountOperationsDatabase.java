package rocks.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountOperationsDatabase {
    private Map<Long, List<AccountOperation>> operationsDatabase;

    public AccountOperationsDatabase() {
        this.operationsDatabase = new HashMap<>();
    }

    public void addOperationToDatabase(long accountID, AccountOperation operation) {
        if (operationsDatabase.get(accountID) == null) {
            operationsDatabase.put(accountID, new ArrayList<>());
        }

        operationsDatabase.get(accountID).add(operation);
    }

    public Map<Long, List<AccountOperation>> getOperationsDatabase() {
        return operationsDatabase;
    }


}
