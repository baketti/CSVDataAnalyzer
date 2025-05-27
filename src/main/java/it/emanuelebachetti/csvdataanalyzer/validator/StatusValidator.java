package it.emanuelebachetti.csvdataanalyzer.validator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * {@code StatusValidator} is a concrete handler in the Chain of Responsibility
 * pattern that validates the transaction status field in a {@link DataRecord}.
 *
 * <p>
 * This validator checks whether the status is one of the allowed values:
 * "completed", "pending", or "failed". It throws an
 * {@link InvalidDataFormatException} if the status is invalid.
 * </p>
 */
public class StatusValidator extends RecordValidator {
    private static final List<String> VALID_STATUSES = List.of("completed", "pending", "failed");

    /**
     * Validates that the status field contains one of the valid status values.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the status is invalid
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        String status = record.getValueAt(5).toLowerCase();
        if (!VALID_STATUSES.contains(status)) {
            throw new InvalidDataFormatException("Invalid status value: " + status);
        }
        validateNext(record);
    }
}
