package it.emanuelebachetti.csvdataanalyzer.validator;

public class TransactionRecordValidatorBuilder {

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

        return idValidator; // punto iniziale della catena
    }
}
