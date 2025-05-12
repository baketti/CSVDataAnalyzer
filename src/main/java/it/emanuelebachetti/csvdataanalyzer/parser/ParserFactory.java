package it.emanuelebachetti.csvdataanalyzer.parser;

public class ParserFactory {
    // @SuppressWarnings("unchecked")
    public static <T> Parser<T> getParser(String type) {
        switch (type.toLowerCase()) {
            case "csv":
                return (Parser<T>) new CsvParser(","); // Default delimiter
            // case "json":
            // return new JsonParser();
            default:
                throw new IllegalArgumentException("Parser type not supported: " + type);
        }
    }
}
