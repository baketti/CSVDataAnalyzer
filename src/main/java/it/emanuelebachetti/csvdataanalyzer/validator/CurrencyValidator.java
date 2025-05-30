package it.emanuelebachetti.csvdataanalyzer.validator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * {@code CurrencyValidator} is a concrete handler in the Chain of
 * Responsibility
 * pattern that validates the currency field in a {@link DataRecord}.
 *
 * <p>
 * This validator checks whether the currency is one of the accepted values:
 * EUR, USD, GBP, or JPY. If the value is invalid or missing, it throws an
 * {@link InvalidDataFormatException}.
 * </p>
 */
public class CurrencyValidator extends RecordValidator {

    private static final List<String> VALID_CURRENCIES = List.of("EUR", "USD", "GBP", "JPY");

    /**
     * Validates that the currency field is present and one of the accepted values.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the currency is invalid or missing
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        try {
            String currency = record.getValueAt(4).toUpperCase(); // Campo currency
            if (!VALID_CURRENCIES.contains(currency)) {
                throw new InvalidDataFormatException("Invalid currency: " + currency);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidDataFormatException("Missing currency field.", e);
        }
        validateNext(record);
    }
}
