package it.emanuelebachetti.csvdataanalyzer.model.adapter;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * Interface for adapting {@link DataRecord} objects into domain-specific
 * models.
 *
 * <p>
 * This interface is part of the <strong>Adapter Pattern</strong>, allowing the
 * system
 * to convert generic CSV data into typed business objects without changing
 * the underlying parsing logic.
 * </p>
 *
 * @param <T> the type of the object to adapt to
 */
public interface RecordAdapter<T> {
    /**
     * Converts a {@code DataRecord} into an object of type {@code T}.
     *
     * @param record the generic CSV record
     * @return a typed object representation
     */
    T adapt(DataRecord record);
}
