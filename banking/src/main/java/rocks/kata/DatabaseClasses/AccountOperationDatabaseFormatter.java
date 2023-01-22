package rocks.kata.DatabaseClasses;

import java.util.List;

import rocks.kata.AccountOperation;

public class AccountOperationDatabaseFormatter {

    public String createFormattedStringForAccountOperations(List<AccountOperation> listOFOperationsForAccount) {
        var toReturn = new StringBuilder();

        toReturn.append("Date\t\tAmount\tBalance\n");
        if (listOFOperationsForAccount != null) {
            for (AccountOperation operation : listOFOperationsForAccount) {
                toReturn.append(operation.toString() + "\n");
            }
        }

        return toReturn.toString().trim();
    }
}
