package it.emanuelebachetti.csvdataanalyzer.parser;

import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParser;

public class ParserFactory {
    @SuppressWarnings("unchecked")
    public static <T> Parser<T> getParser(String type) {
        switch (type.toLowerCase()) {
            case "csv":
                return (Parser<T>) new CSVParser(",");
            default:
                throw new IllegalArgumentException("Parser type not supported: " + type);
        }
    }
}
