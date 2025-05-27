package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * The {@code CSVParseResult} class serves as a container for the result of CSV
 * parsing.
 * It holds both the header row (as a list of column names) and the actual data
 * records.
 *
 * <p>
 * This class is used internally by the {@link CSVParser} to encapsulate and
 * expose
 * the structured representation of a CSV file after parsing.
 * </p>
 */
public class CSVParseResult {

    /** List of header fields from the first line of the CSV. */
    private List<String> header;

    /** List of parsed records from the CSV file. */
    private List<DataRecord> records;

    /**
     * Returns the parsed CSV header fields.
     *
     * @return a list of column names
     */
    public List<String> getHeader() {
        return header;
    }

    /**
     * Returns the list of parsed {@link DataRecord} entries.
     *
     * @return a list of data records
     */
    public List<DataRecord> getRecords() {
        return records;
    }

    /**
     * Sets the header fields parsed from the CSV file.
     *
     * @param header the list of column names
     */
    public void setHeader(List<String> header) {
        this.header = header;
    }

    /**
     * Sets the list of data records parsed from the CSV file.
     *
     * @param records the list of {@link DataRecord}
     */
    public void setRecords(List<DataRecord> records) {
        this.records = records;
    }
}
