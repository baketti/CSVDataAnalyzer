package it.emanuelebachetti.csvdataanalyzer.validator;

/**
 * Builder class for assembling the chain of responsibility for validating
 * {@code DataRecord} instances that represent transactions.
 *
 * <p>
 * This class links together a predefined sequence of validators that
 * check each individual field of a transaction record: transaction ID,
 * timestamp, user ID, amount, currency, and status.
 * </p>
 *
 * <p>
 * It returns the head of the validation chain, which can be passed
 * to validation logic for sequential processing.
 * </p>
 */
public class TransactionRecordValidatorBuilder {

    /**
     * Builds and links all required validators for a transaction.
     *
     * @return the head {@link RecordValidatorHandler} of the validation chain
     */
    public static RecordValidatorHandler build() {
        TransactionIdValidator idValidator = new TransactionIdValidator();
        TimestampValidator timestampValidator = new TimestampValidator();
        UserIdValidator userValidator = new UserIdValidator();
        AmountValidator amountValidator = new AmountValidator();
        CurrencyValidator currencyValidator = new CurrencyValidator();
        StatusValidator statusValidator = new StatusValidator();

        idValidator.setNext(timestampValidator);
        timestampValidator.setNext(userValidator);
        userValidator.setNext(amountValidator);
        amountValidator.setNext(currencyValidator);
        currencyValidator.setNext(statusValidator);

        return idValidator;// head of the chain
    }
}
