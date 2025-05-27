package it.emanuelebachetti.csvdataanalyzer;

import it.emanuelebachetti.csvdataanalyzer.model.*;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import it.emanuelebachetti.csvdataanalyzer.model.adapter.*;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParseResult;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.CSVStructureValidator;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.TransactionCSVValidator;
import it.emanuelebachetti.csvdataanalyzer.parser.factory.Parser;
import it.emanuelebachetti.csvdataanalyzer.parser.factory.ParserFactory;
import it.emanuelebachetti.csvdataanalyzer.validator.RecordValidatorHandler;
import it.emanuelebachetti.csvdataanalyzer.validator.TransactionRecordValidatorBuilder;
import it.emanuelebachetti.csvdataanalyzer.analysis.*;
import it.emanuelebachetti.csvdataanalyzer.cli.AnalysisCLI;
import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;
import it.emanuelebachetti.csvdataanalyzer.exception.InvalidDataFormatException;
import it.emanuelebachetti.csvdataanalyzer.logging.LoggerConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.nio.file.Paths;

/**
 * Main entry point to demonstrate the basic functionalities of the CSV Data
 * Analyzer.
 */
public class App {

    public static void main(String[] args) throws Exception {
        final Logger LOGGER = LoggerConfig.getLogger(App.class);

        System.out.println("\n=============== CSV Data Analyzer ===============\n\n");

        try {
            // 1. Get parser from factory
            Parser<CSVParseResult> parser = ParserFactory.getParser("csv");

            // 2. Parse CSV file
            File file = new File(
                    Paths.get("data/invalid.csv")
                            .toAbsolutePath()
                            .toString());

            CSVParseResult parseResult = parser.parse(file);

            CSVStructureValidator validator = new TransactionCSVValidator();
            validator.validate(parseResult.getHeader());

            // 3. Create dataset, get parse result, set dataset headers and add records
            Dataset dataset = new Dataset();
            dataset.setHeaderFields(parseResult.getHeader());

            List<DataRecord> records = parseResult.getRecords();
            List<Transaction> transactions = new ArrayList<>();

            RecordValidatorHandler validatorChain = TransactionRecordValidatorBuilder.build();
            RecordAdapter<Transaction> adapter = new TransactionAdapter();

            for (DataRecord record : records) {
                try {
                    validatorChain.validate(record);
                    dataset.addComponent(record);
                    transactions.add(adapter.adapt(record));
                } catch (InvalidDataFormatException e) {
                    System.err.println("[ERROR] Validation failed: " + e.getMessage());
                    LOGGER.warning("Validation failed: " + e.getMessage());
                }
            }

            // 4. Display dataset contents
            System.out.println("\n--- Dataset Content ---\n");
            dataset.display();

            Analyzer analyzer = Analyzer.getInstance();
            new AnalysisCLI(analyzer).start(transactions);

        } catch (InvalidCSVStructureException e) {
            System.err.println("[ERROR] Invalid CSV structure: " + e.getMessage());
            LOGGER.warning("Invalid CSV structure: " + e.getMessage());
            System.exit(1);
        } catch (RuntimeException e) {
            // System.err.println(e.getMessage());
            LOGGER.severe("Fatal runtime error: " + e.getMessage());
            System.exit(1);
        }
    }
}
