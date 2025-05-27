package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * {@code TransactionIdValidator} is a concrete handler in the Chain of
 * Responsibility
 * pattern responsible for validating the transaction ID field of a
 * {@link DataRecord}.
 *
 * <p>
 * It checks that the ID is non-null, non-blank, and matches the expected format
 * (e.g., TXN followed by digits).
 * </p>
 */
public class TransactionIdValidator extends RecordValidator {

    /**
     * Validates the transaction ID field.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the ID is missing, blank, or doesn't
     *                                    match the expected pattern
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        String id = record.getValueAt(0);
        if (id == null || id.isBlank() || !id.matches("^TXN\\d+$")) {
            throw new InvalidDataFormatException("Transaction ID is missing or blank.");
        }
        validateNext(record);
    }
}
