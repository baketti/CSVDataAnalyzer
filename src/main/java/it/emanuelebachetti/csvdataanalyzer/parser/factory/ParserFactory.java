package it.emanuelebachetti.csvdataanalyzer.parser.factory;

/**
 * Abstract factory for creating parser instances.
 *
 * <p>
 * This class is part of the <strong>Factory Method Pattern</strong>.
 * Subclasses must implement the {@code createParser()} method to provide
 * specific parser implementations (e.g., CSV, JSON, XML).
 * </p>
 *
 * <p>
 * This approach promotes extensibility by allowing new parser types to be
 * added without modifying existing factory logic.
 * </p>
 */
public abstract class ParserFactory<T> {
    public abstract Parser<T> createParser();
}