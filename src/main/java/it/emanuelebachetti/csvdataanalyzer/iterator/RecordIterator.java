package it.emanuelebachetti.csvdataanalyzer.iterator;

/**
 * An iterator interface for traversing a collection of records.
 */
public interface RecordIterator {

    /**
     * Checks if there are more records in the collection.
     *
     * @return {@code true} if more records are available, {@code false} otherwise
     */
    boolean hasNext();

    /**
     * Returns the next record in the collection.
     *
     * @return the next {@code Record}
     */
    Record next();
}
