package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalAmountAnalysisTest {

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
    void testTotalAmountAnalysisOutput() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", LocalDateTime.now(), "u1", 100.0, "EUR", "completed"),
                new Transaction("t2", LocalDateTime.now(), "u2", 50.5, "EUR", "completed"),
                new Transaction("t3", LocalDateTime.now(), "u3", 200.0, "USD", "completed"));

        AnalysisStrategy strategy = new TotalAmountAnalysis();
        strategy.analyze(transactions);

        String result = output.toString().trim();
        String expectedOutput = """
                Total EUR amount transacted: 150.5
                Total USD amount transacted: 200.0
                """.trim();
        assertEquals(expectedOutput, result);
    }
}
