package it.emanuelebachetti.csvdataanalyzer.parser.factory;

import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParser;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParserFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserFactoryTest {

    @Test
    void shouldReturnCSVParserInstance() {
        CSVParserFactory factory = new CSVParserFactory();
        Parser<?> parser = factory.createParser();
        assertNotNull(parser);
        assertTrue(parser instanceof CSVParser);
    }
}
