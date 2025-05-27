package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionCountByCurrencyTest {

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
    void testTransactionCountByCurrencyOutput() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", LocalDateTime.now(), "u1", 100.0, "EUR", "completed"),
                new Transaction("t2", LocalDateTime.now(), "u2", 200.0, "USD", "completed"),
                new Transaction("t3", LocalDateTime.now(), "u3", 50.0, "EUR", "pending"));

        AnalysisStrategy strategy = new TransactionCountByCurrency();
        strategy.analyze(transactions);

        String printed = output.toString().trim();
        assertTrue(printed.contains("EUR: 2"));
        assertTrue(printed.contains("USD: 1"));
    }
}
