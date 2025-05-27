package it.emanuelebachetti.csvdataanalyzer.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class TransactionRecordValidatorBuilderTest {

    @Test
    void shouldValidateEntireChainSuccessfully() throws InvalidDataFormatException {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord validRecord = new DataRecord(List.of(
                "TXN001", "2024-05-01T10:00", "USR123", "100.0", "EUR", "completed"));

        assertDoesNotThrow(() -> chain.validate(validRecord));
    }

    @Test
    void shouldFailValidationOnInvalidAmount() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "TXN001", "2024-05-01T10:00", "USR123", "invalid", "EUR", "completed"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("amount"));
    }

    @Test
    void shouldFailValidationOnInvalidCurrency() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "TXN001", "2024-05-01T10:00", "USR123", "11.50", "invalid", "completed"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("currency"));
    }

    @Test
    void shouldFailValidationOnInvalidStatus() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "TXN001", "2024-05-01T10:00", "USR123", "11.50", "EUR", "invalid"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("status"));
    }

    @Test
    void shouldFailValidationOnInvalidTimestamp() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "TXN001", "invalid", "USR123", "11.50", "EUR", "completed"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("timestamp"));
    }

    @Test
    void shouldFailValidationOnInvalidTransactionId() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "invalid", "2024-05-01T10:00", "USR123", "11.50", "EUR", "invalid"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("Transaction ID"));
    }

    @Test
    void shouldFailValidationOnInvalidUserId() {
        RecordValidatorHandler chain = TransactionRecordValidatorBuilder.build();

        DataRecord invalidRecord = new DataRecord(List.of(
                "TXN001", "2024-05-01T10:00", "invalid", "11.50", "EUR", "invalid"));

        InvalidDataFormatException ex = assertThrows(
                InvalidDataFormatException.class,
                () -> chain.validate(invalidRecord));

        assertTrue(ex.getMessage().contains("User ID"));
    }

}
