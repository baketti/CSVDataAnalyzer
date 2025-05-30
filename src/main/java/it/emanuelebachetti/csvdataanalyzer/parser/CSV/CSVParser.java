package it.emanuelebachetti.csvdataanalyzer.parser.CSV;

import java.io.*;
import java.util.*;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;
import it.emanuelebachetti.csvdataanalyzer.parser.factory.Parser;

/**
 * {@code CSVParser} is the concrete implementation of the {@link Parser}
 * interface,
 * used in the Factory Method Pattern to parse CSV files and extract their
 * structure.
 *
 * <p>
 * It reads the CSV file line by line, separates values using the CSV delimiter,
 * and transforms each row into a {@link DataRecord}. The result is wrapped in a
 * {@link CSVParseResult}, which contains the header and list of records.
 * </p>
 *
 * <p>
 * All parsing-related exceptions are handled using the {@link ExceptionManager}
 * to
 * maintain clean separation of concerns and ensure safe user feedback.
 * </p>
 */
public class CSVParser<T> implements Parser<CSVParseResult> {

    /** The delimiter used to split CSV fields (e.g., comma). */
    private String delimiter;

    /**
     * Constructs a {@code CSVParser} with a specified delimiter.
     *
     * @param delimiter the character used to split fields in the CSV
     */
    public CSVParser(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Parses the input CSV file into a structured {@link CSVParseResult} object.
     *
     * @param file the CSV file to parse
     * @return a {@link CSVParseResult} containing headers and parsed records
     * @throws IOException if file reading fails
     */
    @Override
    public CSVParseResult parse(File file) throws IOException {
        List<DataRecord> dataRecords = new ArrayList<>();
        CSVParseResult parseResult = new CSVParseResult();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            List<String> CSVheader = List.of(line.split(this.delimiter));
            parseResult.setHeader(CSVheader);
            while ((line = reader.readLine()) != null) {
                List<String> fields = List.of(line.split(delimiter));
                dataRecords.add(new DataRecord(fields));
            }
            parseResult.setRecords(dataRecords);
        } catch (FileNotFoundException e) {
            ExceptionManager.handleException(e, ": CSV file '" + file.getName() + "' not found",
                    CSVParser.class);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            ExceptionManager.handleException(e, ": CSV file parsing", CSVParser.class);
        } catch (NullPointerException e) {
            ExceptionManager.handleException(e, ": CSV file parsing because it's empty", CSVParser.class);
        }

        return parseResult;
    }
}
