package it.emanuelebachetti.csvdataanalyzer.exception;

/**
 * Custom checked exception that indicates the CSV file does not match
 * the expected structure (e.g. missing headers or incorrect format).
 * 
 * By extending {@link Exception}, this class enforces explicit error handling
 * for structural validation of CSV files.
 */
public class InvalidCSVStructureException extends Exception {

    /**
     * Constructs a new {@code InvalidCSVStructureException} with a descriptive
     * message.
     *
     * @param message the explanation of why the structure is invalid
     */
    public InvalidCSVStructureException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code InvalidCSVStructureException} with a message
     * and a root cause exception.
     *
     * @param message the explanation of why the structure is invalid
     * @param cause   the original exception causing this one
     */
    public InvalidCSVStructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
