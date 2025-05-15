package it.emanuelebachetti.csvdataanalyzer.exception;

/**
 * Manages exceptions by logging them and throwing a generic runtime exception
 * with a user-friendly message, shielding internal error details.
 */
public class ExceptionManager {

    /**
     * Handles an exception by logging it internally and re-throwing a safe runtime
     * error.
     *
     * @param e       the original exception
     * @param context description of the component or action
     * @throws RuntimeException shielding exception
     */
    public static void handleException(Exception e, String context) {
        logException(e);
        throw new RuntimeException("Error: " + context + ".");
    }

    // TODO: Log the stack trace on a file

    /**
     * Logs the internal exception details for diagnostic purposes.
     *
     * @param e the exception to log
     */
    private static void logException(Exception e) {
        System.err.println("[LOG] Internal error (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        // e.printStackTrace(); // opzionale per debug
    }
}

// TODO
/*
 * public class CsvParsingException extends Exception { ... }
 * public class InvalidDataFormatException extends RuntimeException { ... }
 * 
 */