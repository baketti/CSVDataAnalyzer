package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * {@code AmountValidator} is a concrete handler in the Chain of Responsibility
 * pattern for validating the transaction amount field in a {@link DataRecord}.
 *
 * <p>
 * This validator checks whether the amount is a valid, non-negative number.
 * If the validation fails due to format issues or missing data, it throws
 * an {@link InvalidDataFormatException}.
 * </p>
 */
public class AmountValidator extends RecordValidator {
    /**
     * Validates that the amount field is a valid non-negative number.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the amount is missing, malformed, or
     *                                    negative
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        try {
            double amount = Double.parseDouble(record.getValueAt(3));
            if (amount < 0) {
                throw new InvalidDataFormatException("Amount must be non-negative.");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new InvalidDataFormatException("Invalid or missing amount.", e);
        }
        validateNext(record);
    }
}
