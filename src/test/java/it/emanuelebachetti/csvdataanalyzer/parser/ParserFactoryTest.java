package it.emanuelebachetti.csvdataanalyzer.parser;

import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserFactoryTest {

    @Test
    void shouldReturnCSVParserWhenTypeIsCsv() {
        Parser<?> parser = ParserFactory.getParser("csv");
        assertNotNull(parser, "Parser should not be null");
        assertTrue(parser instanceof CSVParser, "Parser should be an instance of CSVParser");
    }

    @Test
    void shouldThrowExceptionForUnsupportedParserType() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> ParserFactory.getParser("json"),
                "Expected getParser(\"json\") to throw");

        assertTrue(thrown.getMessage().contains("Parser type not supported"));
    }
}
