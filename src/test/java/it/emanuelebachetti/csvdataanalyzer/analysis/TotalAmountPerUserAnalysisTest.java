package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalAmountPerUserAnalysisTest {

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
    void testTotalAmountPerUserOutput() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", LocalDateTime.now(), "u1", 100.0, "EUR", "completed"),
                new Transaction("t2", LocalDateTime.now(), "u2", 200.0, "USD", "completed"),
                new Transaction("t3", LocalDateTime.now(), "u1", 50.0, "EUR", "completed"),
                new Transaction("t4", LocalDateTime.now(), "u1", 75.0, "USD", "completed"));

        AnalysisStrategy strategy = new TotalAmountPerUserAnalysis();
        strategy.analyze(transactions);

        String result = output.toString().trim();
        String expectedOutput = """
                Total amount per user:
                u1: EUR 150.0
                u1: USD 75.0
                u2: USD 200.0
                """.trim();
        assertEquals(expectedOutput, result);
    }
}
