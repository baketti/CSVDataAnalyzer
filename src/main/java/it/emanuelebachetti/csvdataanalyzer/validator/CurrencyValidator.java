package it.emanuelebachetti.csvdataanalyzer.validator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class CurrencyValidator extends RecordValidator {

    private static final List<String> VALID_CURRENCIES = List.of("EUR", "USD", "GBP", "JPY");

    @Override
    public void validate(DataRecord record) throws ValidationException {
        try {
            String currency = record.getValueAt(4).toUpperCase(); // Campo currency
            if (!VALID_CURRENCIES.contains(currency)) {
                throw new ValidationException("Invalid currency: " + currency);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ValidationException("Missing currency field.");
        }

        validateNext(record);
    }
}
