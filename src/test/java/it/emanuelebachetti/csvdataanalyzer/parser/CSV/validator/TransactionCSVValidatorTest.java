package it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;

public class TransactionCSVValidatorTest {

    private final TransactionCSVValidator validator = new TransactionCSVValidator();

    @Test
    void shouldPassWhenAllRequiredHeadersArePresent() {
        List<String> validHeaders = List.of(
                "transaction_id", "timestamp", "user_id", "amount", "currency", "status");

        assertDoesNotThrow(() -> validator.validate(validHeaders));
    }

    @Test
    void shouldThrowWhenHeaderIsMissing() {
        List<String> missingHeader = List.of(
                "transaction_id", "timestamp", "user_id", "amount", "currency"); // missing "status"

        InvalidCSVStructureException exception = assertThrows(
                InvalidCSVStructureException.class,
                () -> validator.validate(missingHeader));

        assertTrue(exception.getMessage().contains("Missing required header"));
    }
}
