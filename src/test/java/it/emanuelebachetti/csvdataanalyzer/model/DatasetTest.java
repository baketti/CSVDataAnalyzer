package it.emanuelebachetti.csvdataanalyzer.model;

import it.emanuelebachetti.csvdataanalyzer.iterator.RecordIterator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {

    @Test
    void shouldAddComponentsCorrectly() {
        Dataset dataset = new Dataset();
        DataRecord r1 = new DataRecord(List.of("1", "Alice", "30"));
        DataRecord r2 = new DataRecord(List.of("2", "Bob", "25"));

        dataset.addComponent(r1);
        dataset.addComponent(r2);
        assertEquals(2, dataset.getComponents().size());

        dataset.removeComponent(r1);
        assertEquals(1, dataset.getComponents().size());
        assertEquals(r2, dataset.getComponents().get(0));
    }

    @Test
    void shouldRemoveComponentsCorrectly() {
        Dataset dataset = new Dataset();
        DataRecord r1 = new DataRecord(List.of("1", "Alice", "30"));
        DataRecord r2 = new DataRecord(List.of("2", "Bob", "25"));

        dataset.addComponent(r1);
        dataset.addComponent(r2);
        assertEquals(2, dataset.getComponents().size());

        dataset.removeComponent(r1);
        assertEquals(1, dataset.getComponents().size());
        assertEquals(r2, dataset.getComponents().get(0));
    }

    @Test
    void shouldMatchContainedValue() {
        Dataset dataset = new Dataset();
        DataRecord r = new DataRecord(List.of("1", "Alice", "30"));
        dataset.addComponent(r);
    }

    @Test
    void shouldExposeHeaderFields() {
        Dataset dataset = new Dataset();
        List<String> header = List.of("ID", "Name", "Age");
        dataset.setHeaderFields(header);

        assertEquals(header, dataset.getHeaderFields());
    }

    @Test
    void shouldIterateOnlyOverDataRecords() {
        Dataset dataset = new Dataset();
        DataRecord r1 = new DataRecord(List.of("1", "Alice", "30"));
        DataRecord r2 = new DataRecord(List.of("2", "Bob", "25"));
        dataset.addComponent(r1);
        dataset.addComponent(r2);

        RecordIterator iterator = dataset.createIterator();
        int count = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() instanceof DataRecord);
            count++;
        }
        assertEquals(2, count);
    }
}
