package rocks.kata.DatabaseClasses;

import java.util.List;

import rocks.kata.AccountOperation;

public class AccountOperationDatabaseFormatter {

    public String createFormattedStringForAccountOperations(List<AccountOperation> operations) {
        var toReturn = new StringBuilder();

        toReturn.append("Date\t\tAmount\tBalance\n");
        if (operations != null) {
            for (AccountOperation operation : operations) {
                toReturn.append(operation.toString() + "\n");
            }
        }

        return toReturn.toString().trim();
    }
}
