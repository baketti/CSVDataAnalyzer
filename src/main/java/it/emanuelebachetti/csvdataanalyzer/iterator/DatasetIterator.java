package it.emanuelebachetti.csvdataanalyzer.iterator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.DatasetComponent;

/**
 * A concrete iterator for traversing {@code DatasetComponent} elements
 * and returning only the {@code DataRecord} instances.
 * 
 * <p>
 * The next() method related exception is handled using the
 * {@link ExceptionManager} to shield internal errors
 * and prevent system crashes.
 * </p>
 */
public class DatasetIterator implements RecordIterator {

    private List<DatasetComponent> components;
    private int currentIndex = 0;

    /**
     * Constructs a new DatasetIterator with the specified list of components.
     *
     * @param components the list of {@code DatasetComponent} to iterate over
     */
    public DatasetIterator(List<DatasetComponent> components) {
        this.components = components;
    }

    /**
     * Checks if there are more {@code DataRecord} components in the collection.
     *
     * @return {@code true} if another {@code DataRecord} exists, {@code false}
     *         otherwise
     */
    @Override
    public boolean hasNext() {
        while (currentIndex < components.size()) {
            if (components.get(currentIndex) instanceof DataRecord) {
                return true;
            }
            this.currentIndex++;
        }
        return false;
    }

    /**
     * Returns the next {@code DataRecord} in the collection.
     *
     * @return the next {@code DataRecord}
     */
    @Override
    public DataRecord next() {
        try {
            return (DataRecord) components.get(currentIndex++);
        } catch (ClassCastException e) {
            ExceptionManager.handleException(e, "Dataset iteration", DatasetIterator.class);
            return null;
        }
    }
}
