package it.emanuelebachetti.csvdataanalyzer.model.adapter;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.time.LocalDateTime;
import java.util.List;

/**
 * {@code TransactionAdapter} is a concrete adapter that converts
 * a {@link DataRecord} (generic row structure) into a typed
 * {@link Transaction} object.
 *
 * <p>
 * This class plays the role of the <strong>Adapter</strong> in the
 * <strong>Adapter Pattern</strong>, enabling integration between
 * untyped parsed data and structured domain-specific objects.
 * </p>
 *
 * <p>
 * If any field is improperly formatted or missing, the conversion fails
 * gracefully using {@link ExceptionManager} to shield internal errors
 * and prevent system crashes.
 * </p>
 */
public class TransactionAdapter implements RecordAdapter<Transaction> {

    /**
     * Transforms a {@link DataRecord} into a {@link Transaction}.
     *
     * @param record the raw record to transform
     * @return the constructed {@code Transaction} or {@code null} if parsing fails
     */
    @Override
    public Transaction adapt(DataRecord record) {
        try {
            List<String> fields = record.getFields();

            String transactionId = fields.get(0);
            LocalDateTime timestamp = LocalDateTime.parse(fields.get(1));
            String userId = fields.get(2);
            double amount = Double.parseDouble(fields.get(3));
            String currency = fields.get(4);
            String status = fields.get(5);

            return new Transaction(transactionId, timestamp, userId, amount, currency, status);

        } catch (Exception e) {
            ExceptionManager.handleException(e, "while adapting DataRecord to Transaction", Transaction.class);
            return null;
        }
    }
}
