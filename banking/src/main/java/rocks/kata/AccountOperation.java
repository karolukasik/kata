
package rocks.kata;

public class AccountOperation {

    protected enum OperationType {
        OPENING,
        WITHDRAWAL,
        DEPOSIT;
    }

    private OperationType typeOfOperation;
    private int valueOfOperation;
    private int accountBalanceAfterOperation;
    private DateProvider dateProvider = new DateProvider("d.M.yyyy");
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
        return switch (typeOfOperation) {
            case WITHDRAWAL -> dateOfOperation + "\t-" + valueOfOperation + "\t" + accountBalanceAfterOperation;
            case DEPOSIT -> dateOfOperation + "\t+" + valueOfOperation + "\t" + accountBalanceAfterOperation;
            case OPENING -> dateOfOperation + "\t" + valueOfOperation + "\t" + accountBalanceAfterOperation;
        };
    }

}
