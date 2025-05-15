package it.emanuelebachetti.csvdataanalyzer.validator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class StatusValidator extends RecordValidator {
    private static final List<String> VALID_STATUSES = List.of("completed", "pending", "failed");

    @Override
    public void validate(DataRecord record) throws ValidationException {
        String status = record.getValueAt(5).toLowerCase();
        if (!VALID_STATUSES.contains(status)) {
            throw new ValidationException("Invalid status value: " + status);
        }
        validateNext(record);
    }
}
