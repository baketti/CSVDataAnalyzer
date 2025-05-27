package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AverageAmountAnalysisTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testAverageAmountOutput() {
        List<Transaction> transactions = List.of(
                new Transaction("T1", LocalDateTime.now(), "U1", 100.0, "USD", "completed"),
                new Transaction("T2", LocalDateTime.now(), "U2", 200.0, "USD", "completed"));

        AverageAmountAnalysis analysis = new AverageAmountAnalysis();
        analysis.analyze(transactions);

        String result = output.toString().trim();
        assertTrue(result.contains("Average transaction amount: 150.0"));
    }
}
