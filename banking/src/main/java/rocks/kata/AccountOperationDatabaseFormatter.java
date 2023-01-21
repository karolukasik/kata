package rocks.kata;

import java.util.List;

public class AccountOperationDatabaseFormatter {
    private AccountOperationsDatabase operationDatabase;

    public AccountOperationDatabaseFormatter(AccountOperationsDatabase operationsDatabase) {
        this.operationDatabase = operationsDatabase;
    }

    public String format(long accountID) {
        var toReturn = new StringBuilder();
        List<AccountOperation> listOFOperationsForAccountID = operationDatabase.getOperationsDatabase().get(accountID);
        // add check if not null
        toReturn.append("Date\t\tAmount\tBalance\n");
        for (AccountOperation operation : listOFOperationsForAccountID) {
            toReturn.append(operation.toString() + "\n");
        }

        return toReturn.toString().trim();
    }
}
