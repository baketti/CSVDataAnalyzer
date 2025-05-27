package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    @Test
    void shouldParseCSVCorrectly() throws IOException {
        CSVParser parser = new CSVParser(",");
        File file = new File("src/test/data/valid_sample.csv");

        CSVParseResult result = parser.parse(file);

        assertNotNull(result);
        assertEquals(List.of("ID", "Name", "Age"), result.getHeader());
        assertEquals(2, result.getRecords().size());
        assertEquals("Alice", result.getRecords().get(0).getFields().get(1));
    }

    @Test
    void shouldHandleEmptyFileGracefully() throws IOException, RuntimeException {
        CSVParser parser = new CSVParser(",");
        File file = new File("src/test/data/empty.csv");

        assertThrows(RuntimeException.class, () -> parser.parse(file));
    }
}
