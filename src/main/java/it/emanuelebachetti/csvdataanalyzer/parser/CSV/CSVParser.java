package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import java.io.*;
import java.util.*;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.parser.Parser;

public class CSVParser implements Parser<CSVParseResult> {
    private String delimiter;

    public CSVParser(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public CSVParseResult parse(File file) throws IOException {
        List<DataRecord> dataRecords = new ArrayList<>();
        CSVParseResult parseResult = new CSVParseResult();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            List<String> CSVheader = Arrays.asList(line.split(","));
            parseResult.setHeader(CSVheader);
            while ((line = reader.readLine()) != null) {
                List<String> fields = Arrays.asList(line.split(delimiter));
                dataRecords.add(new DataRecord(fields));
            }
            parseResult.setRecords(dataRecords);
        } catch (FileNotFoundException e) {
            ExceptionManager.handleException(e, "CSV file not found");
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            ExceptionManager.handleException(e, "CSV file parsing");
        } catch (NullPointerException e) {
            ExceptionManager.handleException(e, "CSV file parsing because it's empty");
        }

        return parseResult;
    }
}
