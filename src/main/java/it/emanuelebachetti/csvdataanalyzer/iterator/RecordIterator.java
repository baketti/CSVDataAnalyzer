package it.emanuelebachetti.csvdataanalyzer.iterator;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * An iterator interface for traversing a collection of Records.
 */
public interface RecordIterator {

    /**
     * Checks if there are more Records in the collection.
     *
     * @return {@code true} if more DataRecords are available, {@code false}
     *         otherwise
     * 
     */
    boolean hasNext();

    /**
     * Returns the next DataRecord in the collection.
     *
     * @return the next {@code DataRecord}
     */
    DataRecord next();
}
