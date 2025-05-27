package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * {@code UserIdValidator} is a concrete validator in the Chain of
 * Responsibility
 * pattern. It ensures that the user ID field in a {@link DataRecord} is
 * present,
 * non-blank, and matches the expected format (e.g., "USR" followed by digits).
 */
public class UserIdValidator extends RecordValidator {

    /**
     * Validates the user ID field in the given data record.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the user ID is missing, blank, or does
     *                                    not match the expected pattern
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        try {
            String userId = record.getValueAt(2);
            if (userId == null || userId.isBlank() || !userId.matches("^USR\\d+$")) {
                throw new InvalidDataFormatException("User ID is missing or blank.");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidDataFormatException("Missing user_id field.", e);
        }

        validateNext(record);
    }
}
