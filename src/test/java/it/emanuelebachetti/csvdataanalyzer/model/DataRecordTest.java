package it.emanuelebachetti.csvdataanalyzer.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataRecordTest {

    @Test
    void shouldReturnFieldsCorrectly() {
        List<String> fields = List.of("1", "Alice", "30");
        DataRecord record = new DataRecord(fields);

        assertEquals(fields, record.getFields());
    }

    @Test
    void shouldReturnCorrectValueAtIndex() {
        DataRecord record = new DataRecord(List.of("1", "Alice", "30"));

        assertEquals("Alice", record.getValueAt(1));
        assertEquals("30", record.getValueAt(2));
    }

    @Test
    void shouldThrowExceptionForInvalidIndex() {
        DataRecord record = new DataRecord(List.of("1", "Alice", "30"));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            record.getValueAt(5);
        });
    }

    @Test
    void shouldMatchCorrectValue() {
        DataRecord record = new DataRecord(List.of("1", "Alice", "30"));

        assertTrue(record.matches("Alice"));
        assertFalse(record.matches("Bob"));
    }
}
