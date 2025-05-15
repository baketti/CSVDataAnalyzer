package it.emanuelebachetti.csvdataanalyzer;

import it.emanuelebachetti.csvdataanalyzer.model.*;
import it.emanuelebachetti.csvdataanalyzer.parser.*;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParseResult;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.CSVStructureValidator;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.TransactionCSVValidator;
// import it.emanuelebachetti.csvdataanalyzer.iterator.*;
import it.emanuelebachetti.csvdataanalyzer.analyzer.*;
// import it.emanuelebachetti.csvdataanalyzer.exception.*;
import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;

import java.io.File;
import java.util.List;
import java.nio.file.Paths;

/**
 * Main entry point to demonstrate the basic functionalities of the CSV Data
 * Analyzer.
 */
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("=== CSV Data Analyzer ===");

        try {
            // 1. Get parser from factory
            Parser<CSVParseResult> parser = ParserFactory.getParser("csv");

            // 2. Parse CSV file
            File file = new File(
                    Paths.get("data/sample.csv")
                            .toAbsolutePath()
                            .toString());

            CSVParseResult parseResult = parser.parse(file);

            CSVStructureValidator validator = new TransactionCSVValidator();
            validator.validate(parseResult.getHeader());

            // 3. Create dataset, get parse result, set dataset headers and add records
            Dataset dataset = new Dataset();
            dataset.setHeaderFields(parseResult.getHeader());

            List<DataRecord> records = parseResult.getRecords();

            for (DataRecord record : records) {
                dataset.addComponent(record);
            }

            // 4. Display dataset contents
            System.out.println("\n--- Dataset Content ---");
            dataset.display();

            // 5. Run analysis (e.g., on column 2)
            int columnIndex = 1;
            System.out.println("\n--- Statistical Analysis (Column " + columnIndex + ") ---");
            System.out.println("Sum  : " + Analyzer.sum(dataset, columnIndex));
            System.out.println("Mean : " + Analyzer.mean(dataset, columnIndex));
            System.out.println("Min  : " + Analyzer.min(dataset, columnIndex));
            System.out.println("Max  : " + Analyzer.max(dataset, columnIndex));

        } catch (InvalidCSVStructureException e) {
            System.err.println("Error while CSV validation.");
            System.err.println("[LOG] Invalid CSV: " + e.getMessage());
            System.exit(1);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
