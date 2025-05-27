package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class AnalyzerTest {

    private Analyzer analyzer;

    @BeforeEach
    void setup() {
        analyzer = Analyzer.getInstance();
    }

    @Test
    void testExecuteAnalysisWithoutStrategyThrowsException() {
        analyzer.setStrategy(null);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            analyzer.executeAnalysis(List.of());
        });
        assertEquals("Strategy not set.", exception.getMessage());
    }

    @Test
    void testExecuteAnalysisWithStrategyCallsAnalyze() {
        AnalysisStrategy mockStrategy = Mockito.mock(AnalysisStrategy.class);
        List<Transaction> transactions = List.of(); // empty list for simplicity

        analyzer.setStrategy(mockStrategy);
        analyzer.executeAnalysis(transactions);

        verify(mockStrategy, times(1)).analyze(transactions);
    }
}
