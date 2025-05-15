package it.emanuelebachetti.csvdataanalyzer.analyzer;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.Dataset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    Dataset dataset;

    @BeforeEach
    void setUp() {
        dataset = new Dataset();
        dataset.addComponent(new DataRecord(List.of("1", "10.0")));
        dataset.addComponent(new DataRecord(List.of("2", "20.0")));
        dataset.addComponent(new DataRecord(List.of("3", "30.0")));
    }

    @Test
    void shouldCalculateSumCorrectly() {
        double sum = Analyzer.sum(dataset, 1);
        assertEquals(60.0, sum, 0.0001);
    }

    @Test
    void shouldCalculateMeanCorrectly() {
        double mean = Analyzer.mean(dataset, 1);
        assertEquals(20.0, mean, 0.0001);
    }

    @Test
    void shouldFindMaxCorrectly() {
        double max = Analyzer.max(dataset, 1);
        assertEquals(30.0, max, 0.0001);
    }

    @Test
    void shouldFindMinCorrectly() {
        double min = Analyzer.min(dataset, 1);
        assertEquals(10.0, min, 0.0001);
    }

    @Test
    void shouldHandleInvalidNumericValues() {
        dataset.addComponent(new DataRecord(List.of("invalid", "not-a-number")));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            Analyzer.sum(dataset, 1);
        });

        assertTrue(thrown.getMessage().contains("Errore durante il calcolo della somma"));
    }

    @Test
    void shouldHandleEmptyDatasetGracefully() {
        Dataset emptyDataset = new Dataset();
        assertEquals(0.0, Analyzer.sum(emptyDataset, 1));
        assertEquals(0.0, Analyzer.mean(emptyDataset, 1));
        assertEquals(Double.NEGATIVE_INFINITY, Analyzer.max(emptyDataset, 1));
        assertEquals(Double.POSITIVE_INFINITY, Analyzer.min(emptyDataset, 1));
    }
}
