package it.emanuelebachetti.csvdataanalyzer;

import it.emanuelebachetti.csvdataanalyzer.model.*;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import it.emanuelebachetti.csvdataanalyzer.model.adapter.*;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParseResult;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.CSVParserFactory;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.CSVStructureValidator;
import it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator.TransactionCSVValidator;
import it.emanuelebachetti.csvdataanalyzer.parser.factory.Parser;
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
import java.nio.file.Path;

/**
 * Main entry point to demonstrate the basic functionalities of the CSV Data
 * Analyzer.
 */
public class App {

    public static void main(String[] args) throws Exception {
        final Logger LOGGER = LoggerConfig.getLogger(App.class);

        System.out.println("\n================= Welcome to CSV Data Analyzer =================\n\n");

        try {
            // 1. Get parser from factory
            Parser<CSVParseResult> parser = new CSVParserFactory().createParser();

            // 2. Parse CSV file
            File file = new File(
                    Path.of("data", "transactions.csv")
                            .toAbsolutePath()
                            .toString());

            CSVParseResult parseResult = parser.parse(file);

            // 3. Validate CSV structure by checking its headers
            CSVStructureValidator validator = new TransactionCSVValidator();
            validator.validate(parseResult.getHeader());

            // 4. Create dataset and set dataset headers
            Dataset dataset = new Dataset();
            dataset.setHeaderFields(parseResult.getHeader());

            // 5. Initialize the validation chain and adapter
            RecordValidatorHandler validatorChain = TransactionRecordValidatorBuilder.build();
            RecordAdapter<Transaction> adapter = new TransactionAdapter();

            // 6. Get records from parse result and initialize an empty list to store valid
            // transactions
            List<DataRecord> records = parseResult.getRecords();
            List<Transaction> transactions = new ArrayList<Transaction>();

            // 7. Validate records, add and adapt them into their containers
            for (DataRecord record : records) {
                try {
                    validatorChain.validate(record);
                    dataset.addComponent(record);
                    transactions.add(adapter.adapt(record));
                } catch (InvalidDataFormatException e) {
                    System.err.println("[VALIDATION ERROR] Validation failed: " + e.getMessage());
                    LOGGER.warning("Validation failed: " + e.getMessage());
                }
            }

            // 8. Display dataset content
            System.out.println("\n======================== Dataset Content =======================\n");
            dataset.display();

            // 9. Get the Analyzer singleton
            Analyzer analyzer = Analyzer.getInstance();

            // 10. Start the analysis with validated transactions by showing the analysis
            // menu
            new AnalysisCLI(analyzer).start(transactions);

        } catch (InvalidCSVStructureException e) {
            System.err.println("[ERROR] Invalid CSV structure. " + e.getMessage());
            LOGGER.warning("Invalid CSV structure: " + e.getMessage());
            System.exit(1);
        } catch (RuntimeException e) {
            LOGGER.severe("Fatal runtime error: " + e.getMessage());
            System.exit(1);
        }
    }
}
