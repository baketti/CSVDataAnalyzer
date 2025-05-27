package it.emanuelebachetti.csvdataanalyzer.exception;

/**
 * Exception thrown when a field in a record does not match the expected format,
 * e.g., non-numeric value where a number is required.
 */
public class InvalidDataFormatException extends RuntimeException {

    /**
     * Constructs a new InvalidDataFormatException with a descriptive message.
     * 
     * @param message the reason for the exception
     */
    public InvalidDataFormatException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidDataFormatException with message and cause.
     * 
     * @param message the reason for the exception
     * @param cause   the underlying cause
     */
    public InvalidDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
