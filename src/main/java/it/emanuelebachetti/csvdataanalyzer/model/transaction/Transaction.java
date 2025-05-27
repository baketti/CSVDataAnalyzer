package it.emanuelebachetti.csvdataanalyzer.model.transaction;

import java.time.LocalDateTime;

public class Transaction { 

    private final String transactionId;
    private final LocalDateTime timestamp;
    private final String userId;
    private final double amount;
    private final String currency;
    private final String status;

    public Transaction(String transactionId, LocalDateTime timestamp, String userId,
            double amount, String currency, String status) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return transactionId + " | " + timestamp + " | " + userId + " | " + amount + " " + currency + " | " + status;
    }
}
