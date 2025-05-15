package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class AmountValidator extends RecordValidator {
    @Override
    public void validate(DataRecord record) throws ValidationException {
        try {
            double amount = Double.parseDouble(record.getValueAt(3));
            if (amount < 0) {
                throw new ValidationException("Amount must be non-negative.");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new ValidationException("Invalid or missing amount.");
        }
        validateNext(record);
    }
}
