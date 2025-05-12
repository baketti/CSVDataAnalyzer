package it.emanuelebachetti.csvdataanalyzer.model;

import java.util.List;

/**
 * The Record class represents a leaf node in the composite pattern.
 * It implements the DatasetComponent interface and provides
 * operations for an individual record (a CSV row).
 */
public class Record implements DatasetComponent {

    /**
     * The fields of the record (columns).
     */
    private List<String> fields;

    /**
     * Creates a new Record with the specified fields.
     * 
     * @param fields the list of values in the record
     */
    public Record(List<String> fields) {
        this.fields = fields;
    }

    /**
     * Displays the content of the record.
     */
    @Override
    public void display() {
        System.out.println(fields);
    }

    /**
     * Returns the list of fields in the record.
     * 
     * @return list of field values
     */
    public List<String> getFields() {
        return fields;
    }

    /**
     * Retrieves a value at the specified index in the record.
     * 
     * @param index the field index
     * @return the value at that index
     */
    public String getValueAt(int index) {
        return fields.get(index);
    }

    /**
     * Checks whether any field matches the given value.
     */
    @Override
    public boolean matches(String value) {
        return fields.contains(value);
    }
}
