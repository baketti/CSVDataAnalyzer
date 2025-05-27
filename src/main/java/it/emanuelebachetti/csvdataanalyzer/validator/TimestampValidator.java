package it.emanuelebachetti.csvdataanalyzer.validator;

import java.time.format.DateTimeParseException;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

import java.time.LocalDateTime;

/**
 * {@code TimestampValidator} is a concrete handler in the Chain of
 * Responsibility
 * pattern that validates the timestamp string field of a {@link DataRecord}.
 *
 * <p>
 * This validator ensures that the timestamp string can be successfully parsed
 * as a
 * {@link LocalDateTime}. If parsing fails, it throws an
 * {@link InvalidDataFormatException}.
 * </p>
 */
public class TimestampValidator extends RecordValidator {

    /**
     * Validates the timestamp string field by attempting to parse it as a
     * {@link LocalDateTime}.
     *
     * @param record the {@link DataRecord} to validate
     * @throws InvalidDataFormatException if the timestamp is missing or has an
     *                                    invalid format
     */
    @Override
    public void validate(DataRecord record) throws InvalidDataFormatException {
        try {
            LocalDateTime.parse(record.getValueAt(1));
        } catch (DateTimeParseException | IndexOutOfBoundsException e) {
            throw new InvalidDataFormatException("Invalid timestamp format.", e);
        }
        validateNext(record);
    }
}
