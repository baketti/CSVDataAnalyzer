package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StatusCountAnalysisTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testStatusCountAnalysisOutput() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", LocalDateTime.now(), "u1", 100.0, "EUR", "completed"),
                new Transaction("t2", LocalDateTime.now(), "u2", 50.0, "USD", "pending"),
                new Transaction("t3", LocalDateTime.now(), "u1", 200.0, "EUR", "completed"));

        StatusCountAnalysis analysis = new StatusCountAnalysis();
        analysis.analyze(transactions);

        String result = output.toString();
        assertTrue(result.contains("completed: 2"));
        assertTrue(result.contains("pending: 1"));
    }
}
