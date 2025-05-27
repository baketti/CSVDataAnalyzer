package it.emanuelebachetti.csvdataanalyzer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class ExceptionManagerTest {

    @Test
    void shouldThrowRuntimeExceptionWithGenericMessage() {
        Exception ex = new IOException();

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> ExceptionManager.handleException(ex, "testing", ExceptionManager.class));

        assertEquals("Error: testing", thrown.getMessage());
    }
}
