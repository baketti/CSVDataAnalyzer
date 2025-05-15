package it.emanuelebachetti.csvdataanalyzer.model.transaction;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionFactory {

    public static Transaction from(DataRecord record) {
        List<String> fields = record.getFields();

        String transactionId = fields.get(0);
        LocalDateTime timestamp = LocalDateTime.parse(fields.get(1));
        String userId = fields.get(2);
        double amount = Double.parseDouble(fields.get(3));
        String currency = fields.get(4);
        String status = fields.get(5);

        return new Transaction(transactionId, timestamp, userId, amount, currency, status);
    }
}
