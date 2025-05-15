package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class UserIdValidator extends RecordValidator {

    @Override
    public void validate(DataRecord record) throws ValidationException {
        try {
            String userId = record.getValueAt(2);
            if (userId == null || userId.isBlank()) {
                throw new ValidationException("User ID is missing or blank.");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ValidationException("Missing user_id field.");
        }

        validateNext(record);
    }
}
