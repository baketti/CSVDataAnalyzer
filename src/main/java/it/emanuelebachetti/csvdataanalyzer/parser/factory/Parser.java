package it.emanuelebachetti.csvdataanalyzer.parser.factory;

import java.io.File;

/**
 * Generic interface for parsing files into structured domain-specific objects.
 *
 * <p>
 * This interface is part of the <strong>Factory Method Pattern</strong>,
 * enabling flexible and extensible creation of parsers for different file
 * formats
 * such as CSV, JSON, etc.
 * </p>
 *
 * @param <T> the type of result produced by the parser
 */
public interface Parser<T> {
    /**
     * Parses the given file and returns a structured representation.
     *
     * @param file the file to parse
     * @return the parsed result of type {@code T}
     * @throws Exception if parsing fails
     */
    T parse(File file) throws Exception;
}
