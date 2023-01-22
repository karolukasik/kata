package rocks.kata.DatabaseClasses;

import java.util.List;

import rocks.kata.AccountOperation;

public class AccountOperationDatabaseFormatter {
    private AccountOperationsDatabase operationDatabase;

    public AccountOperationDatabaseFormatter(AccountOperationsDatabase operationsDatabase) {
        this.operationDatabase = operationsDatabase;
    }

    public String createFormattedStringForAccountOperation(long accountID) {
        var toReturn = new StringBuilder();

        List<AccountOperation> listOFOperationsForAccountID = operationDatabase.getOperationsDatabase().get(accountID);
        toReturn.append("Date\t\tAmount\tBalance\n");
        if(listOFOperationsForAccountID != null){
            for (AccountOperation operation : listOFOperationsForAccountID) {
                toReturn.append(operation.toString() + "\n");
            }
        }

        return toReturn.toString().trim();
    }
}
