package it.emanuelebachetti.csvdataanalyzer.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * Defines the handler interface for record validation steps in a chain.
 * 
 * <p>
 * Part of the <strong>Chain of Responsibility Pattern</strong>,
 * each implementation is responsible for validating a specific aspect of a
 * {@link DataRecord}. If the validation passes, the request is forwarded to
 * the next handler in the chain.
 * </p>
 */
public interface RecordValidatorHandler {
    /**
     * Sets the next handler in the validation chain.
     *
     * @param next the next handler
     */
    void setNext(RecordValidatorHandler next);

    /**
     * Performs validation on the given record. If valid, passes it to the next
     * handler.
     *
     * @param record the {@code DataRecord} to validate
     * @throws InvalidDataFormatException if the record fails validation
     */
    void validate(DataRecord record) throws InvalidDataFormatException;
}
