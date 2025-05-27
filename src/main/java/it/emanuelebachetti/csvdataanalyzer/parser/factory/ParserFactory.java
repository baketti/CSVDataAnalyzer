package it.emanuelebachetti.csvdataanalyzer.parser.factory;

import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParser;

/**
 * Factory class responsible for instantiating the appropriate parser
 * based on the provided file type.
 *
 * <p>
 * This class implements the <strong>Factory Method Pattern</strong>,
 * allowing the system to be easily extended to support additional file types
 * (e.g., JSON, XML) without modifying existing code.
 * </p>
 */
public class ParserFactory {
    /**
     * Returns an appropriate {@link Parser} instance based on the specified type.
     *
     * @param type the file type (e.g., "csv")
     * @param <T>  the result type returned by the parser
     * @return a parser instance suitable for the given type
     * @throws IllegalArgumentException if the specified type is not supported
     */
    @SuppressWarnings("unchecked")
    public static <T> Parser<T> getParser(String type) {
        switch (type.toLowerCase()) {
            case "csv":
                return (Parser<T>) new CSVParser(",");
            default:
                throw new IllegalArgumentException("Parser type not supported: " + "'" + type + "'"
                        + ". At the moment this program supports only '.csv' files!");
        }
    }
}
