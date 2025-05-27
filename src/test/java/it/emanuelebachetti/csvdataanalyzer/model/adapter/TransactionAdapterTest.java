package it.emanuelebachetti.csvdataanalyzer.model.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

public class TransactionAdapterTest {
    @Test
    void testAdaptDataRecordToTransaction() {
        List<String> fields = List.of("T001", "2024-05-10T12:00", "user123", "99.99", "USD", "completed");
        DataRecord record = new DataRecord(fields);
        TransactionAdapter adapter = new TransactionAdapter();

        Transaction tx = adapter.adapt(record);

        assertNotNull(tx);
        assertEquals("T001", tx.getTransactionId());
        assertEquals(LocalDateTime.parse("2024-05-10T12:00"), tx.getTimestamp());
        assertEquals("user123", tx.getUserId());
        assertEquals(99.99, tx.getAmount());
        assertEquals("USD", tx.getCurrency());
        assertEquals("completed", tx.getStatus());
    }
}
