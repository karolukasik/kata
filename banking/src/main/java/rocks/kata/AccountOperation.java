
package rocks.kata;

import lombok.Setter;

@Setter
public class AccountOperation {
    private CurrentDateProvider dateProvider = new CurrentDateProvider();

    private OperationType typeOfOperation;
    private int valueOfOperation;
    private int accountBalanceAfterOperation;
    private String dateOfOperation;

    public AccountOperation(OperationType typeOfOperation, int valueOfOperation, int accountBalanceAfterOperation) {
        this.typeOfOperation = typeOfOperation;
        this.valueOfOperation = valueOfOperation;
        this.accountBalanceAfterOperation = accountBalanceAfterOperation;
        this.dateOfOperation = dateProvider.getCurrentDate();
    }

    @Override
    public String toString() {
        if (typeOfOperation == OperationType.WITHDRAWAL) {
            return dateOfOperation + "\t-" + valueOfOperation + "\t" + accountBalanceAfterOperation;

        }
        if (typeOfOperation == OperationType.DEPOSIT) {
            return dateOfOperation + "\t+" + valueOfOperation + "\t" + accountBalanceAfterOperation;

        }
        if (typeOfOperation == OperationType.OPENING) {
            return dateOfOperation + "\t" + valueOfOperation + "\t" + accountBalanceAfterOperation;
        }
        return "";
    }

}
