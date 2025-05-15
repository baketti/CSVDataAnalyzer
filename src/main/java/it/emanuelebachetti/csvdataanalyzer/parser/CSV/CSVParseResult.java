package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import java.util.List;

import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

public class CSVParseResult {
    private List<String> header;
    private List<DataRecord> records;

    public List<DataRecord> getRecords() {
        return records;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public void setRecords(List<DataRecord> records) {
        this.records = records;
    }
}
