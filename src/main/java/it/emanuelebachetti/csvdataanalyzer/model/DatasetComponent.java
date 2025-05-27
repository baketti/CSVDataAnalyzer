package it.emanuelebachetti.csvdataanalyzer.model;

/**
 * The DatasetComponent interface represents a component in a composite
 * structure of a dataset. It defines common operations for both
 * individual Records and collections of Records (datasets).
 */
public interface DatasetComponent {

    /**
     * Displays the content of the component.
     */
    void display();
}
