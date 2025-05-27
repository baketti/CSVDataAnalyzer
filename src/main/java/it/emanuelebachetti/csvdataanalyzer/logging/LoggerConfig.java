package it.emanuelebachetti.csvdataanalyzer.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.*;

/**
 * Configures and provides a custom logger for the application.
 * Logs are stored in a file under the `logs/` directory.
 */
public class LoggerConfig {

    /**
     * Returns a configured logger for the specified class.
     * 
     * @param clazz the class requesting the logger
     * @return a customized logger instance
     */
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);
        LoggerConfig.setupLogger(logger);
        return logger;
    }

    /**
     * Configures the provided logger to use a file handler with a custom format.
     * Logs are written to `logs/app.log`.
     * 
     * @param logger the logger to configure
     */
    private static void setupLogger(Logger logger) {

        try {
            Path logDir = Path.of("logs");
            if (Files.notExists(logDir)) {
                Files.createDirectories(logDir);
            }

            FileHandler fileHandler = new FileHandler("logs/app.log", 0, 1, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("[LOGGER ERROR] Unable to initialize file logger: " + e.getMessage());
        }

    }
}
