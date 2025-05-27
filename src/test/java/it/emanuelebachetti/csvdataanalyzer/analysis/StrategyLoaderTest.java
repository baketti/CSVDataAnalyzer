package it.emanuelebachetti.csvdataanalyzer.analysis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyLoaderTest {

    @Test
    void testLoadValidStrategy() {
        AnalysisStrategy strategy = StrategyLoader.load("TotalAmountAnalysis");
        assertNotNull(strategy);
        assertTrue(strategy instanceof TotalAmountAnalysis);
    }

    @Test
    void testLoadInvalidStrategy() {
        assertThrows(RuntimeException.class, () -> StrategyLoader.load("NonExistentStrategy"));
    }
}
