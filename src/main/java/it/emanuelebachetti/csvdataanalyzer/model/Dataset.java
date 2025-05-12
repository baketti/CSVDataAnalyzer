package it.emanuelebachetti.csvdataanalyzer.model;

import java.util.ArrayList;
import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.iterator.DatasetIterator;
import it.emanuelebachetti.csvdataanalyzer.iterator.RecordIterator;

/**
 * The Dataset class represents a composite component in the composite pattern.
 * It implements the DatasetComponent interface and can contain
 * multiple DatasetComponent instances (including Records).
 */
public class Dataset implements DatasetComponent {

    /**
     * The list of components in the dataset.
     */
    private List<DatasetComponent> components = new ArrayList<>();

    /**
     * Adds a component (Record or nested Dataset) to the dataset.
     * 
     * @param component the component to add
     */
    public void addComponent(DatasetComponent component) {
        components.add(component);
    }

    /**
     * Creates an iterator to traverse the dataset and access records.
     *
     * @return a {@code RecordIterator} for this dataset
     */
    public RecordIterator createIterator() {
        return new DatasetIterator(components);
    }

    /**
     * Removes a component from the dataset.
     * 
     * @param component the component to remove
     */
    public void removeComponent(DatasetComponent component) {
        components.remove(component);
    }

    /**
     * Displays the contents of the dataset and its components.
     */
    @Override
    public void display() {
        System.out.println("Dataset:");
        for (DatasetComponent component : components) {
            component.display();
        }
    }

    /**
     * Returns true if any component matches the given value.
     * 
     * @param value the value to search
     */
    @Override
    public boolean matches(String value) {
        for (DatasetComponent component : components) {
            if (component.matches(value))
                return true;
        }
        return false;
    }

    /**
     * Returns the list of all components in the dataset.
     * 
     * @return list of DatasetComponent
     */
    public List<DatasetComponent> getComponents() {
        return components;
    }
}
