package it.emanuelebachetti.csvdataanalyzer.exception;

import java.util.logging.Logger;

import it.emanuelebachetti.csvdataanalyzer.logging.LoggerConfig;

import java.util.logging.Level;

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
    public static void handleException(Exception e, String context, Class<?> origin) {
        System.err.println("[ERROR] An error occurred " + context);
        logException(e, context, origin);
        throw new RuntimeException("Error: " + context);
    }

    /**
     * Logs the internal exception details for diagnostic purposes.
     *
     * @param e the exception to log
     */
    private static void logException(Exception e, String context, Class<?> origin) {
        Logger logger = LoggerConfig.getLogger(origin);
        logger.log(Level.SEVERE, context + " - " + e.getClass().getSimpleName() + ": " + e.getMessage(), e);
    }

}