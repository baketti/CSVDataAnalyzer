package it.emanuelebachetti.csvdataanalyzer.parser;

import java.io.*;
import java.util.*;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.Record;

public class CsvParser implements Parser<List<Record>> {
    private String delimiter;

    public CsvParser(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<Record> parse(File file) throws IOException {
        List<Record> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                records.add(new Record(Arrays.asList(fields)));
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            ExceptionManager.handleException(e, "il parsing del file CSV");
        }

        return records;
    }
}
