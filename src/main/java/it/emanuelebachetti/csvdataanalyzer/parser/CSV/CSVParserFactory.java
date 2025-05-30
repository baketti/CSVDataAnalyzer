package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import it.emanuelebachetti.csvdataanalyzer.parser.factory.ParserFactory;

/**
 * Concrete factory class for creating a CSV parser.
 *
 * <p>
 * Implements the {@link ParserFactory} as part of the Factory Method Pattern.
 * It returns a {@link CSVParser} instance, which handles parsing of CSV files.
 * </p>
 *
 * <p>
 * <strong>Note:</strong> The {@code @SuppressWarnings("unchecked")} annotation
 * is applied
 * because the generic type {@code T} used in {@link ParserFactory} is not
 * explicitly bound
 * to {@link CSVParseResult} in this subclass. Since Java does not support
 * type-checking
 * across generic factory methods with different return types, the cast is safe
 * as long as
 * this factory is exclusively used to create {@link CSVParser} instances
 * returning
 * {@link CSVParseResult}.
 * </p>
 */
public class CSVParserFactory extends ParserFactory {

    @Override
    public CSVParser createParser() {
        return new CSVParser(",");
    }
}
