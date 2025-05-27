package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * Abstract base class for record validators in the Chain of Responsibility.
 * 
 * <p>
 * Implements the {@link RecordValidatorHandler} interface and provides default
 * chaining behavior. Concrete validators should extend this class and implement
 * the specific validation logic in their {@code validate()} method.
 * </p>
 */
public abstract class RecordValidator implements RecordValidatorHandler {
    protected RecordValidatorHandler next;

    /**
     * Sets the next validator in the chain.
     *
     * @param next the next handler to be executed
     */
    @Override
    public void setNext(RecordValidatorHandler next) {
        this.next = next;
    }

    /**
     * Passes the validation to the next handler in the chain if present.
     *
     * @param record the record to be validated
     * @throws InvalidDataFormatException if any validation fails in the chain
     */
    protected void validateNext(DataRecord record) throws InvalidDataFormatException {
        if (next != null) {
            next.validate(record);
        }
    }
}
