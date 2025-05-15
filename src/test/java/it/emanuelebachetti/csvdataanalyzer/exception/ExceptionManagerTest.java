package it.emanuelebachetti.csvdataanalyzer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionManagerTest {

    @Test
    void shouldThrowRuntimeExceptionWithFriendlyMessage() {
        Exception ex = new IllegalArgumentException("Invalid format");

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> ExceptionManager.handleException(ex, "il parsing"),
                "Expected RuntimeException");

        assertTrue(thrown.getMessage().contains("Errore durante il parsing"));
    }
}
