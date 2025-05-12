package it.emanuelebachetti.csvdataanalyzer.model;

/**
 * The DatasetComponent interface represents a component in a composite
 * structure of a dataset. It defines common operations for both
 * individual records and collections of records (datasets).
 */
public interface DatasetComponent {

    /**
     * Displays the content of the component.
     */
    void display();

    /**
     * Checks whether the component contains the specified value.
     * 
     * @param value the value to match
     * @return true if the value is found, false otherwise
     */
    boolean matches(String value);
}
