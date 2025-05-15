package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class TransactionIdValidator extends RecordValidator {
    @Override
    public void validate(DataRecord record) throws ValidationException {
        String id = record.getValueAt(0);
        if (id == null || id.isBlank()) {
            throw new ValidationException("Transaction ID is missing or blank.");
        }
        validateNext(record);
    }
}
