
package rocks.kata;

public class AccountOperation {

    enum OperationType {
        WITHDRAWAL {
            @Override
            String createFormattedStringForDatabase(String date, int value, int balance) {
                return date + "\t-" + value + "\t" + balance;
            }
        },
        DEPOSIT {
            @Override
            String createFormattedStringForDatabase(String date, int value, int balance) {
                return date + "\t+" + value + "\t" + balance;
            }
        };

        abstract String createFormattedStringForDatabase(String date, int value, int balance);
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
        return typeOfOperation.createFormattedStringForDatabase(dateOfOperation, valueOfOperation,
                accountBalanceAfterOperation);
    }

}
