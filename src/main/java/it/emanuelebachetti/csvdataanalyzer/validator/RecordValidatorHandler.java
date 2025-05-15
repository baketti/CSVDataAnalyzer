package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.ValidationException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public interface RecordValidatorHandler {
    void setNext(RecordValidatorHandler next);

    void validate(DataRecord record) throws ValidationException;
}
