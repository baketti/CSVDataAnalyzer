package it.emanuelebachetti.csvdataanalyzer.validator;

import java.time.format.DateTimeParseException;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

import java.time.LocalDateTime;

public class TimestampValidator extends RecordValidator {
    @Override
    public void validate(DataRecord record) throws ValidationException {
        try {
            LocalDateTime.parse(record.getValueAt(1));
        } catch (DateTimeParseException | IndexOutOfBoundsException e) {
            throw new ValidationException("Invalid timestamp format.");
        }
        validateNext(record);
    }
}
