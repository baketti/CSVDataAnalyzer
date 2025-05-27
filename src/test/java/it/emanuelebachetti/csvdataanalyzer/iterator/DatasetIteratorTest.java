package it.emanuelebachetti.csvdataanalyzer.iterator;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.DatasetComponent;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

class DatasetIteratorTest {

    @Test
    void shouldReturnOnlyDataRecords() {
        DataRecord r1 = new DataRecord(List.of("1", "Alice"));
        DataRecord r2 = new DataRecord(List.of("2", "Bob"));

        DatasetComponent mockComponent = Mockito.mock(DatasetComponent.class);

        DatasetIterator iterator = new DatasetIterator(List.of(r1, mockComponent, r2));

        assertTrue(iterator.hasNext());
        assertEquals(r1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(r2, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldReturnFalseIfNoDataRecords() {

        DatasetComponent mockComponentWithoutRecords = Mockito.mock(DatasetComponent.class);

        DatasetIterator iterator = new DatasetIterator(List.of(mockComponentWithoutRecords));

        assertFalse(iterator.hasNext());
    }
}
