package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public abstract class RecordValidator implements RecordValidatorHandler {
    protected RecordValidatorHandler next;

    @Override
    public void setNext(RecordValidatorHandler next) {
        this.next = next;
    }

    protected void validateNext(DataRecord record) throws ValidationException {
        if (next != null) {
            next.validate(record);
        }
    }
}
