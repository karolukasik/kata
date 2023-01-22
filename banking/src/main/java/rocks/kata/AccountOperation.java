
package rocks.kata;

public class AccountOperation {

    private OperationType typeOfOperation;
    private int valueOfOperation;
    private int accountBalanceAfterOperation;
    private CurrentDateProvider dateProvider = new CurrentDateProvider();
    private String dateOfOperation;

    public AccountOperation(OperationType typeOfOperation, int valueOfOperation, int accountBalanceAfterOperation) {
        this.typeOfOperation = typeOfOperation;
        this.valueOfOperation = valueOfOperation;
        this.accountBalanceAfterOperation = accountBalanceAfterOperation;
        this.dateOfOperation = dateProvider.getCurrentDate();
    }

    @Override
    public String toString() {
        return createFormattedStringForAccountOperation();
    }

    private String createFormattedStringForAccountOperation() {
        switch (typeOfOperation) {
            case WITHDRAWAL:
                return dateOfOperation + "\t-" + valueOfOperation + "\t" + accountBalanceAfterOperation;
            case DEPOSIT:
                return dateOfOperation + "\t+" + valueOfOperation + "\t" + accountBalanceAfterOperation;
            case OPENING:
                return dateOfOperation + "\t" + valueOfOperation + "\t" + accountBalanceAfterOperation;
            default:
                return "Unknown operation type";
        }
    }

}
