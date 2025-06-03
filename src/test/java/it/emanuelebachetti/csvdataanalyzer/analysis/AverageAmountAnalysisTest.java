package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                new Transaction("T2", LocalDateTime.now(), "U2", 200.0, "USD", "completed"),
                new Transaction("T3", LocalDateTime.now(), "U3", 300.0, "EUR", "completed"),
                new Transaction("T4", LocalDateTime.now(), "U4", 400.0, "EUR", "completed"));

        AverageAmountAnalysis analysis = new AverageAmountAnalysis();
        analysis.analyze(transactions);

        String result = output.toString().trim();
        String expectedOutput = """
                Average EUR amount transacted: 350.00
                Average USD amount transacted: 150.00
                """.trim();
        assertEquals(expectedOutput, result);
    }
}
