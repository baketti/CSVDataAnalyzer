package it.emanuelebachetti.csvdataanalyzer.model;

import java.util.List;

/**
 * The DataRecord class represents a leaf node in the composite pattern.
 * It implements the DatasetComponent interface and provides
 * operations for an individual DataRecord (a CSV row).
 */
public class DataRecord implements DatasetComponent {

    /**
     * The fields of the DataRecord (columns).
     */
    private List<String> fields;

    /**
     * Creates a new DataRecord with the specified fields.
     * 
     * @param fields the list of values in the Record
     */
    public DataRecord(List<String> fields) {
        this.fields = fields;
    }

    /**
     * Displays the content of the Record.
     */
    @Override
    public void display() {
        System.out.println(fields);
    }

    /**
     * Returns the list of fields in the Record.
     * 
     * @return list of field values
     */
    public List<String> getFields() {
        return fields;
    }

    /**
     * Retrieves a value at the specified index within its fields.
     * 
     * @param index the field index
     * @return the value at that index
     */
    public String getValueAt(int index) {
        return fields.get(index);
    }
}
