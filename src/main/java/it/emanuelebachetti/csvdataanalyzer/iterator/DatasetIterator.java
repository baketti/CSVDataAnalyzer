package it.emanuelebachetti.csvdataanalyzer.iterator;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.model.DatasetComponent;

/**
 * A concrete iterator for traversing {@code DatasetComponent} elements
 * and returning only the {@code Record} instances.
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
     * Checks if there are more {@code Record} components in the collection.
     *
     * @return {@code true} if another {@code Record} exists, {@code false}
     *         otherwise
     */
    @Override
    public boolean hasNext() {
        while (currentIndex < components.size()) {
            if (components.get(currentIndex) instanceof Record) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    /**
     * Returns the next {@code Record} in the collection.
     *
     * @return the next {@code Record}
     */
    @Override
    public DataRecord next() {
        try {
            return (DataRecord) components.get(currentIndex++);
        } catch (ClassCastException e) {
            ExceptionManager.handleException(e, "l’iterazione sul Dataset");
            return null; // mai raggiunto, ma richiesto dal compilatore
        }
    }
}
